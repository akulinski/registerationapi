package com.akulinski.registerationapi.core.services.validation;

import com.akulinski.registerationapi.core.domain.repository.UserRepository;
import com.akulinski.registerationapi.core.services.exception.BlankUsernameException;
import com.akulinski.registerationapi.core.services.exception.NonAlphaNumericException;
import com.akulinski.registerationapi.core.services.exception.TooShortUsernameException;
import com.akulinski.registerationapi.core.services.exception.UserAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public class UsernameValidationStrategy implements ValidationStrategy {
  private final UserRepository userRepository;

  @Override
  public void validate(String value) {
    if (StringUtils.isBlank(value)) {
      throw new BlankUsernameException();
    }

    if (value.length() < 5) {
      throw new TooShortUsernameException();
    }

    if (!StringUtils.isAlphanumeric(value)) {
      throw new NonAlphaNumericException();
    }

    if (userRepository.findByUsername_Username(value).isPresent()) {
      throw new UserAlreadyExists(value);
    }
  }
}
