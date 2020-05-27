package com.akulinski.registerationapi.web.rest.v1;

import com.akulinski.registerationapi.core.services.dto.ValidationErrorDTO;
import com.akulinski.registerationapi.core.services.exception.FieldValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RegistrationExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({FieldValidationException.class})
  public ResponseEntity<ValidationErrorDTO> handleAccessDeniedException(
      FieldValidationException ex, WebRequest request) {

    return new ResponseEntity<>(
        new ValidationErrorDTO(ex.filed(), ex.rule()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
}
