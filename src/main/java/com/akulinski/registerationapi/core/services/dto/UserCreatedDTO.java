package com.akulinski.registerationapi.core.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedDTO {
  private Long id;
  private String username;
}
