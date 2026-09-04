package com.bootcamp.self_bc_mtr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.self_bc_mtr.dto.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto handleIllegalArgument(IllegalArgumentException ex) {
    return ErrorDto.builder()
        .code(9)
        .message(ex.getMessage())
        .build();
  }
}