package com.pismo.paymentService.transactions.impl;

import com.pismo.paymentService.accounts.AccountRepository;
import com.pismo.paymentService.accounts.domain.Account;
import com.pismo.paymentService.common.exception.BusinessDomainException;
import com.pismo.paymentService.operations.OperationTypeRepository;
import com.pismo.paymentService.operations.domain.OperationType;
import com.pismo.paymentService.transactions.TransactionRepository;
import com.pismo.paymentService.transactions.TransactionService;
import com.pismo.paymentService.transactions.api.NewTransactionRequest;
import com.pismo.paymentService.transactions.domain.Transaction;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** The type Transaction service. */
@Service
public class TransactionServiceImpl implements TransactionService {
  private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

  private TransactionRepository transactionRepository;
  private AccountRepository accountRepository;
  private OperationTypeRepository operationTypeRepository;

  /**
   * Instantiates a new Transaction service.
   *
   * @param transactionRepository the transaction repository
   * @param accountRepository the account repository
   * @param operationTypeRepository the operation type repository
   */
  public TransactionServiceImpl(
      TransactionRepository transactionRepository,
      AccountRepository accountRepository,
      OperationTypeRepository operationTypeRepository) {
    this.transactionRepository = transactionRepository;
    this.accountRepository = accountRepository;
    this.operationTypeRepository = operationTypeRepository;
  }

  /**
   * Create transaction transaction.
   *
   * @param request the request
   * @return the transaction
   */
  @Override
  @Transactional(TxType.REQUIRES_NEW)
  public Transaction createTransaction(NewTransactionRequest request)
      throws BusinessDomainException {
    Transaction transaction = this.processNewTransaction(request);
    this.transactionRepository.save(transaction);
    log.debug("Transaction [{}] was saved successfully.", transaction);
    return transaction;
  }

  private Transaction processNewTransaction(NewTransactionRequest request)
      throws BusinessDomainException {
    Transaction transaction = new Transaction();

    // Set Account
    Optional<Account> optionalAccount = this.accountRepository.findById(request.getAccountId());
    if (optionalAccount.isEmpty()) {
      log.info("Provided account [{}] does not exist.", request.getAccountId());
      throw new BusinessDomainException("error.invalid-account");
    }
    transaction.setAccount(optionalAccount.get());

    // Set operationType
    Optional<OperationType> optionalOperationType =
        this.operationTypeRepository.findById(request.getOperationTypeId());
    if (optionalOperationType.isEmpty()) {
      log.info("Provided operation type [{}] does not exist.", request.getOperationTypeId());
      throw new BusinessDomainException("error.invalid-operation-type");
    }
    transaction.setOperationType(optionalOperationType.get());

    if (request.getAmount().equals(0D)) {
      throw new BusinessDomainException("error.invalid-amount");
    }
    // Set amount
    transaction.setAmount(request.getAmount());
    return transaction;
  }
}
