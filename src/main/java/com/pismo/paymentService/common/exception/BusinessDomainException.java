package com.pismo.paymentService.common.exception;

import java.io.Serializable;

/** The type Business domain exception. */
public class BusinessDomainException extends Exception implements Serializable {
  private static final long serialVersionUID = -5028434767513251947L;
  private final String errorCode;

  /**
   * Constructs a new exception with {@code null} as its detail message. The cause is not
   * initialized, and may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param errorCode the error code
   */
  public BusinessDomainException(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * Gets error code.
   *
   * @return the error code
   */
  public String getErrorCode() {
    return errorCode;
  }
}
