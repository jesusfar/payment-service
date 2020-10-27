package com.pismo.paymentService.operations.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** The type Operation type. */
@Entity
@Table(name = "OPERATION_TYPE")
public class OperationType implements Serializable {
  private static final long serialVersionUID = -7851807011799484401L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "operation_type_id")
  private Integer operationTypeId;
  private String description;
  @Column(name = "is_payment")
  private boolean isPayment;

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
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Is payment boolean.
   *
   * @return the boolean
   */
  public boolean isPayment() {
    return isPayment;
  }

  /**
   * Sets payment.
   *
   * @param payment the payment
   */
  public void setPayment(boolean payment) {
    isPayment = payment;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    OperationType that = (OperationType) obj;
    return isPayment == that.isPayment && Objects.equals(operationTypeId, that.operationTypeId) && Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationTypeId, description, isPayment);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("OperationType{");
    sb.append("operationTypeId=").append(operationTypeId);
    sb.append(", description='").append(description).append('\'');
    sb.append(", isPayment=").append(isPayment);
    sb.append('}');
    return sb.toString();
  }
}
