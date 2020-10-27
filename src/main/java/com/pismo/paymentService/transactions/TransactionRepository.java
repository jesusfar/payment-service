package com.pismo.paymentService.transactions;

import com.pismo.paymentService.transactions.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** The interface Transaction repository. */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
