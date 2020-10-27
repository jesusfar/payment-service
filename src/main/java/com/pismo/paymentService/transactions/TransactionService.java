package com.pismo.paymentService.transactions;

import com.pismo.paymentService.common.exception.BusinessDomainException;
import com.pismo.paymentService.transactions.api.NewTransactionRequest;
import com.pismo.paymentService.transactions.domain.Transaction;

/** The interface Transaction service. */
public interface TransactionService {
  /**
   * Create transaction transaction.
   *
   * @param request the request
   * @return the transaction
   */
  Transaction createTransaction(NewTransactionRequest request) throws BusinessDomainException;
}
