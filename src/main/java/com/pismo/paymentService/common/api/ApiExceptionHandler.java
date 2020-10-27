package com.pismo.paymentService.common.api;

import com.pismo.paymentService.common.exception.BusinessDomainException;
import com.pismo.paymentService.common.exception.RuntimeSystemException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.AuthenticationException;
import javax.persistence.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    String code = "error.malformed-json-request";
    String message = "Malformed JSON body request";

    return toResponse(new ApiErrorResponse(code, message, status.value()));
  }

  @ExceptionHandler(EntityNotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
    String code = "error.entity-not-found";
    String message = "Error entity not found";

    return toResponse(new ApiErrorResponse(code, message, HttpStatus.NOT_FOUND.value()));
  }

  @ExceptionHandler(BusinessDomainException.class)
  protected ResponseEntity<Object> handleBusinessDomainException(BusinessDomainException ex) {
    String code = ex.getErrorCode();
    String message = "Error business domain exception"; // TODO handle i18n messages

    return toResponse(new ApiErrorResponse(code, message, HttpStatus.BAD_REQUEST.value()));
  }

  @ExceptionHandler(RuntimeSystemException.class)
  protected ResponseEntity<Object> handleRuntimeSystemException(RuntimeSystemException ex) {
    String code = "error.system-exception";
    String message = "Sorry! there is an error processing the request.";

    return toResponse(
        new ApiErrorResponse(code, message, HttpStatus.INTERNAL_SERVER_ERROR.value()));
  }

  @ExceptionHandler(AuthenticationException.class)
  protected ResponseEntity<Object> handleAuthenticationExceptionException(
      AuthenticationException ex) {
    String code = "error.unauthorized-exception";
    String message = "Unauthorized";
    return toResponse(new ApiErrorResponse(code, message, HttpStatus.UNAUTHORIZED.value()));
  }

  /*
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            objectError -> {
              String field = ((FieldError) objectError).getField();
              String message = objectError.getDefaultMessage();
              errors.put(field, message);
            });
    return toResponse(
        new ApiErrorResponse(
            "error.validation-exception",
            "Validation exception",
            HttpStatus.BAD_REQUEST.value(),
            errors));
  }*/

  /**
   * Customize the response for MethodArgumentNotValidException.
   * <p>This method delegates to {@link #handleExceptionInternal}.
   *
   * @param ex the exception
   * @param headers the headers to be written to the response
   * @param status the selected response status
   * @param request the current request
   * @return a {@code ResponseEntity} instance
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            objectError -> {
              String field = ((FieldError) objectError).getField();
              String message = objectError.getDefaultMessage();
              errors.put(field, message);
            });
    return toResponse(
        new ApiErrorResponse(
            "error.validation-exception",
            "Validation exception",
            HttpStatus.BAD_REQUEST.value(),
            errors));
  }

  private ResponseEntity<Object> toResponse(ApiErrorResponse apiErrorResponse) {
    return new ResponseEntity<>(apiErrorResponse, HttpStatus.valueOf(apiErrorResponse.getStatus()));
  }
}
