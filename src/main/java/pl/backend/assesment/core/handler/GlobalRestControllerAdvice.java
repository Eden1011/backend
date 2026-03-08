package pl.backend.assesment.core.handler;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.backend.assesment.core.exception.BusinessException;
import pl.backend.assesment.core.exception.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponseDto> handleBusinessException(
      BusinessException ex, HttpServletRequest request) {
    ErrorResponseDto body =
        ErrorResponseDto.builder()
            .timestamp(LocalDateTime.now())
            .status(ex.getHttpStatus().value())
            .error(ex.getHttpStatus().getReasonPhrase())
            .message(ex.getMessage())
            .path(request.getRequestURI())
            .build();
    return ResponseEntity.status(ex.getHttpStatus()).body(body);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDto> handleValidationException(
      MethodArgumentNotValidException ex, HttpServletRequest request) {
    Map<String, String> validationErrors = new HashMap<>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(error -> validationErrors.put(error.getField(), error.getDefaultMessage()));
    ErrorResponseDto body =
        ErrorResponseDto.builder()
            .timestamp(LocalDateTime.now())
            .status(ex.getStatusCode().value())
            .error("Validation failed")
            .message("Request validation failed")
            .path(request.getRequestURI())
            .validationErrors(validationErrors)
            .build();
    return ResponseEntity.badRequest().body(body);
  }
}
