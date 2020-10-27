package com.pismo.paymentService.transactions;

import com.pismo.paymentService.common.exception.BusinessDomainException;
import com.pismo.paymentService.transactions.api.NewTransactionRequest;
import com.pismo.paymentService.transactions.api.TransactionResponse;
import com.pismo.paymentService.transactions.domain.Transaction;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** The type Transaction controller. */
@RestController
@RequestMapping("/transactions")
@Tag(name = "Transactions", description = "Transactions domain")
public class TransactionController {
  private final TransactionService transactionService;

  /**
   * Instantiates a new Transaction controller.
   *
   * @param transactionService the transaction service
   */
  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  /**
   * Create transaction response entity.
   *
   * @param request the request
   * @return the response entity
   */
  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TransactionResponse> createTransaction(
      @RequestBody NewTransactionRequest request) throws BusinessDomainException {
    Transaction transaction = this.transactionService.createTransaction(request);
    return new ResponseEntity<>(this.toResponse(transaction), HttpStatus.CREATED);
  }

  private TransactionResponse toResponse(Transaction transaction) {
    TransactionResponse response = new TransactionResponse();
    response.setTransactionId(transaction.getTransactionId());
    response.setAccountId(transaction.getAccount().getAccountId());
    response.setOperationTypeId(transaction.getOperationType().getOperationTypeId());
    response.setAmount(transaction.getAmount());
    return response;
  }
}
