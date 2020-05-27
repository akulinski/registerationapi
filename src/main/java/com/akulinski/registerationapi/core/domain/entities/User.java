package com.akulinski.registerationapi.core.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "application_user")
@Data
public final class User {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  private final Username username;

  private final Password password;

  public User(Username username, Password password) {
    this.username = username;
    this.password = password;
  }
  // Added for hibernate
  private User() {
    this.username = null;
    this.password = null;
  }
}
