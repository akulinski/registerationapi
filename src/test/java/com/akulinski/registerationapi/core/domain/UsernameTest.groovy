package com.akulinski.registerationapi.core.domain

import com.akulinski.registerationapi.core.domain.entities.Username
import spock.lang.Specification

class UsernameTest extends Specification {

    def "blank username should not be allowed"() {
        given:
        Username username;
        when:
        username = new Username(" ");
        then:
        thrown(IllegalArgumentException)
    }

    def "length < 5 should not be allowed"() {
        given:
        Username username;
        when:
        username = new Username("qwer");
        then:
        thrown(IllegalArgumentException)
    }

    def "special characters should not be allowed"() {
        given:
        Username username;
        when:
        username = new Username("qwer!@#.,]]\\");
        then:
        thrown(IllegalArgumentException)
    }

    def "null should not be allowed"() {
        given:
        Username username;
        when:
        username = new Username(null);
        then:
        thrown(NullPointerException)
    }

    def "alphannumeric username > 5 should be allowed"() {
        given:
        Username username;
        when:
        username = new Username("testusername1");
        then:
        noExceptionThrown()
    }
}
