package pl.backend.assesment.core.exception;

import org.springframework.http.HttpStatus;

public interface BusinessExceptionPolicyInterface {
  String getMessage();

  HttpStatus getHttpStatus();
}
