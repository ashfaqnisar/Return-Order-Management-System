package com.returnordermanagement.paymentmodule.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.returnordermanagement.paymentmodule.exception.CardNotFoundException;
import com.returnordermanagement.paymentmodule.model.CreditCard;
import com.returnordermanagement.paymentmodule.repository.CreditCardRepository;

@Component
@Transactional
public class CreditCardService {

    @Autowired
    private CreditCardRepository cardRepository;


    public double processPayment(long cardNumber, double charge) throws CardNotFoundException {
        CreditCard creditCard = cardRepository.findByCardNumber(cardNumber);

        if (creditCard != null) {

            double cardLimit = creditCard.getCardLimit();

            if (cardLimit > 0) {
                double balance = cardLimit - charge;
                if (balance > 0) {
                    creditCard.setCardLimit(balance);
                    cardRepository.save(creditCard);
                    return balance;
                }
            }
        } else
            throw new CardNotFoundException("Card Not Found");
        return -1;
    }
}
