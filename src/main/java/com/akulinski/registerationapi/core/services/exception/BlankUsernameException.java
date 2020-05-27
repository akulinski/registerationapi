package com.akulinski.registerationapi.core.services.exception;

public class BlankUsernameException extends FieldValidationException {
  public static final String SHOULD_NOT_BE_BLANK = "username should not be blank";

  public BlankUsernameException() {
    super(SHOULD_NOT_BE_BLANK);
  }

  @Override
  public String filed() {
    return "username";
  }

  @Override
  public String rule() {
    return "username must not be blank";
  }
}
