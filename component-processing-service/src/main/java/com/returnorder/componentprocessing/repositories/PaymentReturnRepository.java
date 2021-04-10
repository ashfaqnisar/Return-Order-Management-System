package com.returnorder.componentprocessing.repositories;

import com.returnorder.componentprocessing.entity.PaymentReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReturnRepository extends JpaRepository<PaymentReturn, Integer> {
}
