package com.akulinski.registerationapi.core.domain.entities;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class Username {
  private static final long serialVersionUID = 1L;

  @Column(length = 50, unique = true, nullable = false)
  private final String username;

  public Username(@NonNull String username) {

    if (username.length() < 5
        || !StringUtils.isAlphanumeric(username)
        || StringUtils.isBlank(username)) {

      throw new IllegalArgumentException("Invalid username");
    }

    this.username = username;
  }

  // Added for hibernate
  private Username() {
    this.username = null;
  }

  public String asString() {
    return username;
  }
}
