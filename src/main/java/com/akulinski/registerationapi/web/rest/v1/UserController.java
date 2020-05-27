package com.akulinski.registerationapi.web.rest.v1;

import com.akulinski.registerationapi.core.services.ApplicationRegistrationService;
import com.akulinski.registerationapi.core.services.dto.UserCreatedDTO;
import com.akulinski.registerationapi.core.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

  private final ApplicationRegistrationService applicationRegistrationService;

  @PostMapping
  public ResponseEntity<UserCreatedDTO> createUser(@Valid @RequestBody UserDTO userDTO) {

    final var userCreated = applicationRegistrationService.createUser(userDTO);

    return ResponseEntity.created(URI.create("/api/v1/user/" + userCreated.getId()))
        .body(userCreated);
  }
}
