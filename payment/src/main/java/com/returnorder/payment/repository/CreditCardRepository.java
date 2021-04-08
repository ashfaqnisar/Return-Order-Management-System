package com.returnorder.payment.repository;

import com.returnorder.payment.entity.CreditCard;
import com.returnorder.payment.exception.CardNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
    CreditCard findByCardNumber(long cardNumber) throws CardNotFoundException;
}
