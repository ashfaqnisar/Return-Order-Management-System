package com.returnorder.componentprocessing.services;

import com.returnorder.componentprocessing.entity.PaymentReturn;
import com.returnorder.componentprocessing.entity.ReturnRequest;
import com.returnorder.componentprocessing.feignClients.PackagingAndDeliveryFeignClient;
import com.returnorder.componentprocessing.feignClients.PaymentFeignClient;
import com.returnorder.componentprocessing.payload.PaymentResponse;
import com.returnorder.componentprocessing.payload.ReturnRequestPayload;
import com.returnorder.componentprocessing.payload.ReturnResponsePayload;
import com.returnorder.componentprocessing.repositories.PaymentReturnRepository;
import com.returnorder.componentprocessing.repositories.ReturnRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

@Service
@Slf4j
public class ReturnProcessService {
    private final ReturnRequestRepository returnRequestRepository;
    private final PaymentReturnRepository paymentReturnRepository;
    private final PaymentFeignClient paymentFeignClient;
    private final PackagingAndDeliveryFeignClient packagingAndDeliveryFeignClient;

    @Autowired
    public ReturnProcessService(
            ReturnRequestRepository returnRequestRepository,
            PaymentReturnRepository paymentReturnRepository,
            PaymentFeignClient paymentFeignClient,
            PackagingAndDeliveryFeignClient packagingAndDeliveryFeignClient) {
        this.returnRequestRepository = returnRequestRepository;
        this.paymentReturnRepository = paymentReturnRepository;
        this.paymentFeignClient = paymentFeignClient;
        this.packagingAndDeliveryFeignClient = packagingAndDeliveryFeignClient;
    }

    public ReturnResponsePayload processReturnRequest(ReturnRequestPayload returnRequestPayload) {
        ReturnRequest returnRequest = new ReturnRequest();
        ReturnResponsePayload returnResponsePayload = new ReturnResponsePayload();

        BeanUtils.copyProperties(returnRequestPayload, returnRequest);

        int processingDays = 5;
        double processingCharge = returnRequestPayload.getComponentType().equalsIgnoreCase("integral") ? 500 : 300;

        if (returnRequestPayload.isPriorityRequest()) {
            processingDays = 2;
            processingCharge += 200;
        }
        LocalDate date = LocalDate.now().plusDays(processingDays);
        returnRequest.setProcessingCharge(processingCharge);
        returnRequest.setDateOfDelivery(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        returnRequest.setRequestId(UUID.randomUUID().toString().replace("-", ""));

        returnRequest.setPackageAndDeliveryCharge(packagingAndDeliveryFeignClient.getPackagingAndDeliveryCharge(
                returnRequestPayload.getComponentType(), returnRequestPayload.getQuantity())
        );

        returnRequestRepository.save(returnRequest);

        BeanUtils.copyProperties(returnRequest, returnResponsePayload);

        return returnResponsePayload;

    }

    public String makePayment(String requestId, long cardNumber, double processingCharge) {
        PaymentReturn paymentRequest = new PaymentReturn(requestId, cardNumber, processingCharge);

        paymentReturnRepository.save(paymentRequest);

        log.info("Works here");

        PaymentResponse paymentResponse = paymentFeignClient.getCurrentBalance(cardNumber, processingCharge);
        log.info("Crashed here");
        log.info(paymentResponse.toString());

        if (paymentResponse.getCurrentBalance() <= -1)
            return "Insufficient Balance";
        else
            return "Payment Successfully";
    }
}
