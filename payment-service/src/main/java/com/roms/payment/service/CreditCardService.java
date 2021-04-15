package com.roms.payment.service;

import com.roms.payment.entity.CreditCard;
import com.roms.payment.exception.CardNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roms.payment.repository.CreditCardRepository;

import javax.transaction.Transactional;

@Component
@Transactional
@Slf4j
public class CreditCardService {
    private final CreditCardRepository cardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public double processPayment(long cardNumber, double charge) throws CardNotFoundException {
        CreditCard creditCard = cardRepository.findByCardNumber(cardNumber);

        if (creditCard == null) {
            throw new CardNotFoundException(cardNumber);
        }

        double cardLimit = creditCard.getCardLimit();

        if (cardLimit > 0) {
            double balance = cardLimit - charge;
            if (balance > 0) {
                creditCard.setCardLimit(balance);
                cardRepository.save(creditCard);
                return balance;
            }
        }
        return -1;
    }

}