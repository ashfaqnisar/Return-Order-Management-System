package com.returnorder.componentprocessing.repositories;

import com.returnorder.componentprocessing.entity.ReturnRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRequestRepository extends JpaRepository<ReturnRequest, Integer> {
}
