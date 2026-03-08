package pl.backend.assesment.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BusinessExceptionReasonEnum implements BusinessExceptionPolicyInterface {
  PRODUCT_NOT_FOUND("Product not found", HttpStatus.NOT_FOUND),
  PRODUCER_NOT_FOUND("Producer not found", HttpStatus.NOT_FOUND),
  ATTRIBUTE_TYPE_NOT_FOUND("Attribute type not found", HttpStatus.NOT_FOUND),
  PRODUCER_NAME_ALREADY_EXISTS("Producer with this name already exists", HttpStatus.CONFLICT),
  ATTRIBUTE_TYPE_NAME_ALREADY_EXISTS(
      "Attribute type with this name already exists", HttpStatus.CONFLICT);

  private final String message;
  private final HttpStatus httpStatus;
}
