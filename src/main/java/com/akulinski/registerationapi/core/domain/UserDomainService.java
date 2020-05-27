package com.akulinski.registerationapi.core.domain;

import com.akulinski.registerationapi.core.domain.entities.Password;
import com.akulinski.registerationapi.core.domain.entities.User;
import com.akulinski.registerationapi.core.domain.entities.Username;
import com.akulinski.registerationapi.core.domain.repository.UserRepository;
import com.akulinski.registerationapi.core.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDomainService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User createUser(UserDTO userDTO) {

    final var user =
        new User(new Username(userDTO.getUsername()), new Password(getHashedPassword(userDTO)));

    return userRepository.save(user);
  }

  private String getHashedPassword(UserDTO userDTO) {
    return passwordEncoder.encode(userDTO.getPassword());
  }
}
