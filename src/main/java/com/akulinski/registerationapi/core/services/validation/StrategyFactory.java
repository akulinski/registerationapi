package com.akulinski.registerationapi.core.services.validation;

import com.akulinski.registerationapi.core.domain.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StrategyFactory {
  private final UserRepository userRepository;

  public ValidationStrategy getStrategy(@NonNull ValidationStrategyType strategy) {
    switch (strategy) {
      case USERNAME:
        return new UsernameValidationStrategy(userRepository);
      case PASSWORD:
        return new PasswordValidationStrategy();
      default:
        throw new IllegalArgumentException("Invalid strategy");
    }
  }

}
