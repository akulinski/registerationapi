package com.akulinski.registerationapi.core.services;

import com.akulinski.registerationapi.core.domain.UserDomainService;
import com.akulinski.registerationapi.core.services.dto.UserCreatedDTO;
import com.akulinski.registerationapi.core.services.dto.UserDTO;
import com.akulinski.registerationapi.core.services.validation.StrategyFactory;
import com.akulinski.registerationapi.core.services.validation.ValidationStrategyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationRegistrationService {
  private final UserDomainService userDomainService;

  private final StrategyFactory strategyFactory;

  public UserCreatedDTO createUser(UserDTO userDTO) {

    strategyFactory.getStrategy(ValidationStrategyType.USERNAME).validate(userDTO.getUsername());

    strategyFactory.getStrategy(ValidationStrategyType.PASSWORD).validate(userDTO.getPassword());

    final var user = userDomainService.createUser(userDTO);

    return new UserCreatedDTO(user.getId(), user.getUsername().asString());
  }
}
