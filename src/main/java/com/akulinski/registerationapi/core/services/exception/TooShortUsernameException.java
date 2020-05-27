package com.akulinski.registerationapi.core.services.exception;

public class TooShortUsernameException extends FieldValidationException {

  public static final String AT_LEAST_5_CHARACTERS_LONG =
      "username should be at least 5 characters long";

  public TooShortUsernameException() {
    super(AT_LEAST_5_CHARACTERS_LONG);
  }

  @Override
  public String filed() {
    return "username";
  }

  @Override
  public String rule() {
    return  "username must contain at least 5 characters";
  }
}
