package com.pismo.paymentService.transactions.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotBlank;

/** The type Transaction response. */
public class NewTransactionRequest implements Serializable {
  private static final long serialVersionUID = -5325820822814963906L;
  @JsonProperty(value = "account_id")
  @NotBlank(message = "validation.constraints.NotBlank.account_id")
  private Long accountId;
  @JsonProperty(value = "operation_type_id")
  @NotBlank(message = "validation.constraints.NotBlank.operation_type_id")
  private Integer operationTypeId;
  @JsonProperty(value = "amount")
  @NotBlank(message = "validation.constraints.NotBlank.amount")
  private Double amount;

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
    NewTransactionRequest that = (NewTransactionRequest) obj;
    return Objects.equals(accountId, that.accountId) && Objects.equals(operationTypeId, that.operationTypeId) && Objects.equals(amount, that.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, operationTypeId, amount);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("TransactionResponse{");
    sb.append("accountId=").append(accountId);
    sb.append(", operationTypeId=").append(operationTypeId);
    sb.append(", amount=").append(amount);
    sb.append('}');
    return sb.toString();
  }
}
