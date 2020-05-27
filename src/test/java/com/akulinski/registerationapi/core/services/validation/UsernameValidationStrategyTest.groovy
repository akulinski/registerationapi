package com.akulinski.registerationapi.core.services.validation

import com.akulinski.registerationapi.core.domain.entities.Password
import com.akulinski.registerationapi.core.domain.entities.User
import com.akulinski.registerationapi.core.domain.entities.Username
import com.akulinski.registerationapi.core.domain.repository.UserRepository
import com.akulinski.registerationapi.core.services.exception.BlankUsernameException
import com.akulinski.registerationapi.core.services.exception.NonAlphaNumericException
import com.akulinski.registerationapi.core.services.exception.TooShortUsernameException
import com.akulinski.registerationapi.core.services.exception.UserAlreadyExists
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import spock.lang.Specification

class UsernameValidationStrategyTest extends Specification {

    private UserRepository userRepository;

    private UsernameValidationStrategy usernameValidationStrategy;

    void setup() {
        userRepository = Mock()
        usernameValidationStrategy = new UsernameValidationStrategy(userRepository)

    }

    def "Validate blank username"() {
        given:
        String username = " "
        userRepository.findByUsername_Username(" ") >> Optional.empty()

        when:
        usernameValidationStrategy.validate(username)
        then:
        thrown(BlankUsernameException)
    }


    def "username should have at least 5 characters"() {
        given:
        String username = "asdf"
        userRepository.findByUsername_Username(username) >> Optional.empty()

        when:
        usernameValidationStrategy.validate(username)
        then:
        thrown(TooShortUsernameException)
    }

    def "username should be alphanumeric"() {
        given:
        String username = "asdf~!@#^&^"
        userRepository.findByUsername_Username(username) >> Optional.empty()

        when:
        usernameValidationStrategy.validate(username)
        then:
        thrown(NonAlphaNumericException)
    }

    def "username should be unique"() {

        given:
        String username = "username"
        userRepository.findByUsername_Username(username) >> Optional.of(new User(new Username("username"), new Password(new BCryptPasswordEncoder().encode("password"))))

        when:
        usernameValidationStrategy.validate(username)

        then:
        thrown(UserAlreadyExists)
    }
}
