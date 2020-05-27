package com.akulinski.registerationapi.core.domain.entities;

import com.akulinski.registerationapi.core.services.exception.TooShortPasswordException;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class Password {
  private static final long serialVersionUID = 1L;

  @Column(name = "password_hash", nullable = false)
  private final String password;

  public Password(@NonNull String password) {

    if (password.length() < 60) {
      throw new TooShortPasswordException();
    }

    this.password = password;
  }

  // Added for hibernate
  private Password() {
    this.password = null;
  }
}
