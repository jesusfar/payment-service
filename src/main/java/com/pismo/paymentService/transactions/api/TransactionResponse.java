package com.pismo.paymentService.transactions.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

/** The type Transaction response. */
public class TransactionResponse implements Serializable {
  private static final long serialVersionUID = -5325820822814963906L;
  @JsonProperty(value = "transaction_id")
  private Long transactionId;
  @JsonProperty(value = "account_id")
  private Long accountId;
  @JsonProperty(value = "operation_type_id")
  private Integer operationTypeId;
  @JsonProperty(value = "amount")
  private Double amount;

  /**
   * Gets transaction id.
   *
   * @return the transaction id
   */
  public Long getTransactionId() {
    return transactionId;
  }

  /**
   * Sets transaction id.
   *
   * @param transactionId the transaction id
   */
  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  /**
   * Gets account id.
   *
   * @return the account id
   */
  public Long getAccountId() {
    return accountId;
  }

  /**
   * Sets account id.
   *
   * @param accountId the account id
   */
  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  /**
   * Gets operation type id.
   *
   * @return the operation type id
   */
  public Integer getOperationTypeId() {
    return operationTypeId;
  }

  /**
   * Sets operation type id.
   *
   * @param operationTypeId the operation type id
   */
  public void setOperationTypeId(Integer operationTypeId) {
    this.operationTypeId = operationTypeId;
  }

  /**
   * Gets amount.
   *
   * @return the amount
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * Sets amount.
   *
   * @param amount the amount
   */
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TransactionResponse that = (TransactionResponse) obj;
    return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountId, that.accountId) && Objects.equals(operationTypeId,
        that.operationTypeId) && Objects.equals(amount, that.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, accountId, operationTypeId, amount);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("TransactionResponse{");
    sb.append("transactionId=").append(transactionId);
    sb.append(", accountId=").append(accountId);
    sb.append(", operationTypeId=").append(operationTypeId);
    sb.append(", amount=").append(amount);
    sb.append('}');
    return sb.toString();
  }
}
