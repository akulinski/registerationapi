package com.akulinski.registerationapi.core.services.exception;

public class UserAlreadyExists extends FieldValidationException {

  public static final String USERNAME_S_ALREADY_EXISTS = "User with username %s already exists";

  public UserAlreadyExists(String s) {
    super(String.format(USERNAME_S_ALREADY_EXISTS, s));
  }

  @Override
  public String filed() {
    return "username";
  }

  @Override
  public String rule() {
    return "username already exists";
  }
}
