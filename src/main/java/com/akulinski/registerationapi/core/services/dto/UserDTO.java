package com.akulinski.registerationapi.core.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  @Size(max = 250)
  private String username;

  @Size(max = 250)
  private String password;
}
