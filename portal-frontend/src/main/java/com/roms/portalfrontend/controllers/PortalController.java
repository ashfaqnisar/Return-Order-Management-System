package com.roms.portalfrontend.controllers;

import com.roms.portalfrontend.AuthResponsePayload;
import com.roms.portalfrontend.feignClient.AuthFeignClient;
import com.roms.portalfrontend.feignClient.ReturnFeignClient;
import com.roms.portalfrontend.payload.PaymentResponsePayload;
import com.roms.portalfrontend.payload.ReturnRequestPayload;
import com.roms.portalfrontend.payload.ReturnResponsePayload;
import com.roms.portalfrontend.payload.UserLoginRequestPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class PortalController {
    private final AuthFeignClient authFeignClient;
    private final ReturnFeignClient returnFeignClient;

    private ReturnResponsePayload returnResponsePayload;

    @Autowired
    public PortalController(AuthFeignClient authFeignClient, ReturnFeignClient returnFeignClient) {
        this.authFeignClient = authFeignClient;
        this.returnFeignClient = returnFeignClient;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    /*
     * Checks the session for the user object is present or not.
     * */
    @GetMapping("/")
    public String homePage(HttpSession session) {
        try {
            AuthResponsePayload response = (AuthResponsePayload) session.getAttribute("user");
            authFeignClient.validateToken(response.getToken());
            return "home.html";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/payment")
    public String paymentPage(HttpSession session) {
        try {
            AuthResponsePayload response = (AuthResponsePayload) session.getAttribute("user");
            authFeignClient.validateToken(response.getToken());
            String requestId = returnResponsePayload.getRequestId();
            log.info(requestId);
            return "payment.html";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PostMapping("/processLogin")
    public String processLogin(UserLoginRequestPayload userLoginRequestPayload, HttpSession session) {
        try {
            log.info(userLoginRequestPayload.toString());
            AuthResponsePayload authResponsePayload = authFeignClient.generateToken(userLoginRequestPayload);
            session.setAttribute("user", authResponsePayload);
            return "redirect:/";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "redirect:/login?error=true";
        }
    }

    @PostMapping("/processReturnRequest")
    public String processReturnRequest(ReturnRequestPayload returnRequestPayload, HttpSession session) {
        try {
            log.info(returnRequestPayload.toString());
            AuthResponsePayload authResponsePayload = (AuthResponsePayload) session.getAttribute("user");
            returnResponsePayload = returnFeignClient.createReturnRequest(authResponsePayload.getToken(), returnRequestPayload);
            return "redirect:/payment";
        } catch (NullPointerException e) {
            return "redirect:/login";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "redirect:/?retry=true";
        }
    }

    @PostMapping("/processPaymentForRequest")
    public String processPaymentForRequest(@RequestParam long cardNumber, HttpSession session) {
        try {
            log.info(String.valueOf(cardNumber));

            String requestId = returnResponsePayload.getRequestId();
            double processingCharge = returnResponsePayload.getProcessingCharge();
            AuthResponsePayload authResponsePayload = (AuthResponsePayload) session.getAttribute("user");

            PaymentResponsePayload responsePayload = returnFeignClient.makePaymentForReturnRequest(
                    authResponsePayload.getToken(),
                    requestId,
                    cardNumber,
                    processingCharge);
            if (responsePayload.getCurrentBalance() <= 0) {
                return "redirect:/payment?insufficientBalance=true";
            }
            returnResponsePayload = null;
            return "success.html";
        } catch (NullPointerException e) {
            return "redirect:/login";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "failed.html";
        }
    }

    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout=true";
    }
}
