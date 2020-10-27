package com.pismo.paymentService.accounts.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/** The type Account. */
@Entity
@Table(name = "ACCOUNT", uniqueConstraints = @UniqueConstraint(columnNames = {"document_number"}))
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id")
  private Long accountId;

  @Column(name = "document_number")
  private String documentNumber;

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
   * Gets document number.
   *
   * @return the document number
   */
  public String getDocumentNumber() {
    return documentNumber;
  }

  /**
   * Sets document number.
   *
   * @param documentNumber the document number
   */
  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }
}
