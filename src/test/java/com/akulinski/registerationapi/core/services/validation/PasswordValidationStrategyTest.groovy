package com.akulinski.registerationapi.core.services.validation

import com.akulinski.registerationapi.core.services.exception.PasswordStrengthException
import com.akulinski.registerationapi.core.services.exception.TooShortPasswordException
import spock.lang.Specification

class PasswordValidationStrategyTest extends Specification {

    private PasswordValidationStrategy passwordValidationStrategy;

    void setup() {
        passwordValidationStrategy = new PasswordValidationStrategy();
    }

    def "Password should have at least 7 chars"(){
        given:
        String password = "pass";
        when:
        passwordValidationStrategy.validate(password)
        then:
        thrown(TooShortPasswordException)
    }

    def "Password should have numbers"(){
        given:
        String password = "passwordddD";
        when:
        passwordValidationStrategy.validate(password)
        then:
        thrown(PasswordStrengthException)
    }

    def "Password should have uppercase"(){
        given:
        String password = "passworddd1";
        when:
        passwordValidationStrategy.validate(password)
        then:
        thrown(PasswordStrengthException)
    }


    def "Password should have lowercase"(){
        given:
        String password = "DDDDDDDDDDDDDDDD1";
        when:
        passwordValidationStrategy.validate(password)
        then:
        thrown(PasswordStrengthException)
    }

}
