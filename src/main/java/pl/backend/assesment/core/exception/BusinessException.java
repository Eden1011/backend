package pl.backend.assesment.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
  private final String message;
  private final HttpStatus httpStatus;

  public BusinessException(BusinessExceptionReasonEnum reason) {
    super(reason.getMessage());
    this.message = reason.getMessage();
    this.httpStatus = reason.getHttpStatus();
  }
}
