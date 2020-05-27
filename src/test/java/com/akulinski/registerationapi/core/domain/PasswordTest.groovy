package com.akulinski.registerationapi.core.domain

import com.akulinski.registerationapi.core.domain.entities.Password
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import spock.lang.Specification

class PasswordTest extends Specification {

    def "password should not be null"() {
        given:
        Password password;
        when:
        password = new Password(null);
        then:
        thrown(NullPointerException)
    }

    def "hashed password should be valid"() {
        given:
        def encode = new BCryptPasswordEncoder().encode("Some Password")
        Password password;
        when:
        password = new Password(encode)
        then:
        noExceptionThrown()
    }
}
