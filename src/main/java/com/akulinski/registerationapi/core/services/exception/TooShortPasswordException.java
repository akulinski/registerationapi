package com.akulinski.registerationapi.core.services.exception;

public class TooShortPasswordException extends FieldValidationException {
  public static final String AT_LEAST_8_CHARACTERS_LONG =
      "password should be at least 8 characters long";

  public TooShortPasswordException() {
    super(AT_LEAST_8_CHARACTERS_LONG);
  }

  @Override
  public String filed() {
    return "password";
  }

  @Override
  public String rule() {
    return "password must contain at least 8 characters";
  }
}
