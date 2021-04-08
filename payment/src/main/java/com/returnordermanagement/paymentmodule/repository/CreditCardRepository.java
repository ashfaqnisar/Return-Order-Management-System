package com.returnordermanagement.paymentmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.returnordermanagement.paymentmodule.exception.CardNotFoundException;
import com.returnordermanagement.paymentmodule.model.CreditCard;

@Component
public interface CreditCardRepository extends JpaRepository<CreditCard,String>{

	CreditCard findByCardNumber(long cardNumber) throws CardNotFoundException;
}
