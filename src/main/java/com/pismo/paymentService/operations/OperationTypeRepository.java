package com.pismo.paymentService.operations;

import com.pismo.paymentService.operations.domain.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType, Integer> {
}
