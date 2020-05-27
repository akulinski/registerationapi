package com.akulinski.registerationapi.core.services.dto;

import lombok.Data;

@Data
public class ValidationErrorDTO {
  private final String field;
  private final String rule;
}
