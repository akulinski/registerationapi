package com.akulinski.registerationapi.core.domain.repository;

import com.akulinski.registerationapi.core.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findByUsername_Username(String username);
}
