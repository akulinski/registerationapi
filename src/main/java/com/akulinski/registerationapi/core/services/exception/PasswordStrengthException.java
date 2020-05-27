package com.akulinski.registerationapi.core.services.exception;

public class PasswordStrengthException extends FieldValidationException {
  private final String rule;

  public PasswordStrengthException(String s, String rule) {
    super(s);
    this.rule = rule;
  }

  @Override
  public String filed() {
    return "password";
  }

  @Override
  public String rule() {
    return rule;
  }
}
