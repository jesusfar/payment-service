package com.pismo.paymentService.transactions.domain;

import static java.lang.Math.abs;

import com.pismo.paymentService.accounts.domain.Account;
import com.pismo.paymentService.operations.domain.OperationType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** The type Transaction. */
@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "transaction_id")
  private Long transactionId;

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  @ManyToOne
  @JoinColumn(name = "operation_type_id")
  private OperationType operationType;
  private Double amount;

  @Column(name = "event_date")
  private Date eventDate;

  /** Instantiates a new Transaction. */
  public Transaction() {
    this.eventDate = new Date();
  }

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
   * Gets account.
   *
   * @return the account
   */
  public Account getAccount() {
    return account;
  }

  /**
   * Sets account.
   *
   * @param account the account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  /**
   * Gets operation type.
   *
   * @return the operation type
   */
  public OperationType getOperationType() {
    return operationType;
  }

  /**
   * Sets operation type.
   *
   * @param operationType the operation type
   */
  public void setOperationType(OperationType operationType) {
    this.operationType = operationType;
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
    if (this.operationType != null && this.operationType.isPayment()) {
      this.amount = abs(amount) * 1;
    } else {
      this.amount = abs(amount) * -1;
    }
  }

  /**
   * Gets event dated.
   *
   * @return the event dated
   */
  public Date getEventDate() {
    return eventDate;
  }

  /**
   * Sets event dated.
   *
   * @param eventDate the event dated
   */
  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Transaction that = (Transaction) obj;
    return Objects.equals(transactionId, that.transactionId) && Objects.equals(account, that.account) && Objects.equals(operationType,
        that.operationType) && Objects.equals(amount, that.amount) && Objects.equals(eventDate, that.eventDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, account, operationType, amount, eventDate);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Transaction{");
    sb.append("transactionId=").append(transactionId);
    sb.append(", account=").append(account);
    sb.append(", operationType=").append(operationType);
    sb.append(", amount=").append(amount);
    sb.append(", eventDated=").append(eventDate);
    sb.append('}');
    return sb.toString();
  }
}
