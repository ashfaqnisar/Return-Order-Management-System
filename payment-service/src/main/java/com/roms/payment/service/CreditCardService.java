package com.roms.payment.service;

import com.roms.payment.entity.CreditCard;
import com.roms.payment.exception.CardNotFoundException;
import com.roms.payment.exception.InsufficientBalanceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roms.payment.repository.CreditCardRepository;

import javax.naming.InsufficientResourcesException;
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

    public double processPayment(long cardNumber, int cvv, double charge) throws CardNotFoundException {
        CreditCard creditCard = cardRepository.findByCardNumber(cardNumber);

        if (creditCard == null || creditCard.getCvv() != cvv) {
            throw new CardNotFoundException(cardNumber);
        }

        double cardLimit = creditCard.getCardBalance();
        double balance = cardLimit > 0 ? cardLimit - charge : -1;

        if (balance >= 0) {
            creditCard.setCardBalance(balance);
            cardRepository.save(creditCard);
            return balance;
        }

        throw new InsufficientBalanceException("Insufficient Balance");
    }

}
