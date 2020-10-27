package com.pismo.paymentService.common.api;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** The type Api error response. */
public class ApiErrorResponse {
  private String code;
  private String message;
  private String timestamp;
  private int status;
  private Map<String, String> details = new HashMap<>();

  /**
   * Instantiates a new Api error response.
   *
   * @param code the code
   * @param message the message
   * @param status the status
   */
  public ApiErrorResponse(String code, String message, int status) {
    this.code = code;
    this.message = message;
    this.status = status;
    this.timestamp = Instant.now().toString();
  }

  /**
   * Instantiates a new Api error response.
   *
   * @param code the code
   * @param message the message
   * @param status the status
   * @param details the details
   */
  public ApiErrorResponse(String code, String message, int status, Map<String, String> details) {
    this(code, message, status);
    this.details = details;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets code.
   *
   * @param code the code
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Sets timestamp.
   *
   * @param timestamp the timestamp
   */
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * Gets details.
   *
   * @return the details
   */
  public Map<String, String> getDetails() {
    return details;
  }

  /**
   * Sets details.
   *
   * @param details the details
   */
  public void setDetails(Map<String, String> details) {
    this.details = details;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ApiErrorResponse that = (ApiErrorResponse) obj;
    return status == that.status && Objects.equals(code, that.code) && Objects.equals(message, that.message) && Objects.equals(timestamp,
        that.timestamp) && Objects.equals(details, that.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, timestamp, status, details);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ApiErrorResponse{");
    sb.append("code='").append(code).append('\'');
    sb.append(", message='").append(message).append('\'');
    sb.append(", timestamp='").append(timestamp).append('\'');
    sb.append(", status=").append(status);
    sb.append(", details=").append(details);
    sb.append('}');
    return sb.toString();
  }
}
