package com.pismo.paymentService.accounts.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

/** The type Account response. */
public class AccountResponse implements Serializable {
  private static final long serialVersionUID = 8921294381416358294L;
  @JsonProperty(value = "account_id")
  private Long accountId;
  @JsonProperty(value = "document_number")
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AccountResponse response = (AccountResponse) obj;
    return Objects.equals(accountId, response.accountId) && Objects.equals(documentNumber, response.documentNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, documentNumber);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("AccountResponse{");
    sb.append("accountId=").append(accountId);
    sb.append(", documentNumber='").append(documentNumber).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
