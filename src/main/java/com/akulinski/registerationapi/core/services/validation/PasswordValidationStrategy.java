package com.akulinski.registerationapi.core.services.validation;

import com.akulinski.registerationapi.core.services.exception.PasswordStrengthException;
import com.akulinski.registerationapi.core.services.exception.TooShortPasswordException;
import lombok.NonNull;

import java.util.regex.Pattern;

public class PasswordValidationStrategy implements ValidationStrategy {

  private final Pattern atLeastOneLower = Pattern.compile("^.*[a-z]+.*$");

  private final Pattern atLeastOneUpper = Pattern.compile("^.*[A-Z]+.*$");

  private final Pattern atLeastOneNumber = Pattern.compile("^.*[0-9]+.*$");

  @Override
  public void validate(@NonNull String value) {

    if (value.length() < 8) {
      throw new TooShortPasswordException();
    }

    if (checkDontMatch(value, atLeastOneLower)) {
      throw new PasswordStrengthException(
          "Missing lowercase letter", "password must contain lowercase letter");
    }
    if (checkDontMatch(value, atLeastOneUpper)) {
      throw new PasswordStrengthException(
          "Missing uppercase letter", "password must contain uppercase letter");
    }
    if (checkDontMatch(value, atLeastOneNumber)) {
      throw new PasswordStrengthException("Missing number", "password must contain number");
    }
  }

  private boolean checkDontMatch(@NonNull String value, Pattern pattern) {
    return !pattern.matcher(value).matches();
  }
}
