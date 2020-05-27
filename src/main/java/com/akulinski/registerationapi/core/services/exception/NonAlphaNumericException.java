package com.akulinski.registerationapi.core.services.exception;

public class NonAlphaNumericException extends FieldValidationException {

  public static final String ONLY_ALPHA_NUMERIC_VALUES =
      "username should contain only alpha-numeric values";

  public NonAlphaNumericException() {
    super(ONLY_ALPHA_NUMERIC_VALUES);
  }

  @Override
  public String filed() {
    return "username";
  }

  @Override
  public String rule() {
    return "username cannot contain non alphanumeric characters";
  }
}
