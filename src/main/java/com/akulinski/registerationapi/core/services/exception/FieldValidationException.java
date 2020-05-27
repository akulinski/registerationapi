package com.akulinski.registerationapi.core.services.exception;

public abstract class FieldValidationException extends IllegalArgumentException {

  public FieldValidationException(String s) {
    super(s);
  }

  public abstract String filed();

  public abstract String rule();
}
