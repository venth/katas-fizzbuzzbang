package appender

import spock.lang.Specification

class BangAppenderSpec extends Specification {

    def bangAppender = new BangAppender()

    def BANG = "Bang"

    def 'Appends "BANG" to a given string'() {
        given:
            def anyString = "someString"
        when:
            def result = bangAppender.appendBangTo(anyString)
        then:
            result == anyString + BANG
    }
}
