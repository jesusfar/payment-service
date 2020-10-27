package com.pismo.paymentService.accounts.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotBlank;

/** The type New account request. */
public class NewAccountRequest implements Serializable {
  private static final long serialVersionUID = -7112092369178868462L;

  @JsonProperty(value = "document_number")
  @NotBlank(message = "validation.constraints.NotBlank.document_number")
  private String documentNumber;

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
    NewAccountRequest request = (NewAccountRequest) obj;
    return Objects.equals(documentNumber, request.documentNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentNumber);
  }
}
