package com.roms.payment.repository;

import com.roms.payment.entity.CreditCard;
import com.roms.payment.exception.CardNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
    CreditCard findByCardNumber(long cardNumber) throws CardNotFoundException;
}
