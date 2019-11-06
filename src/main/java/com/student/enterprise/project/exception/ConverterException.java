package com.student.enterprise.project.exception;

public class ConverterException extends RuntimeException {

  public ConverterException(String errorMessage) {
    super(errorMessage);
  }

  public ConverterException(String errorMessage, Throwable ex) {
    super(errorMessage, ex);
  }

}
