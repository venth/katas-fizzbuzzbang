package fizzbuzzer

import appender.BangAppender
import factory.behavior.AppenderBehaviorFactory
import spock.lang.Specification

class ExtendedFizzBuzzerSpec extends Specification {


    def FIZZ = "Fizz"
    def BUZZ = "Buzz"
    def BANG = "Bang"
    def POW = "Pow"
    def MRRU = "Mrru"

    def bangThreshold = 15

    def bangAppender = Mock(BangAppender)

    AppenderBehaviorFactory behaviorFactory = AppenderBehaviorFactory.getInstance()

    ExtendedFizzBuzzer extendedFizzBuzzer = new ExtendedFizzBuzzer(bangAppender, bangThreshold, behaviorFactory.createBehaviorList())

    def 'On integers divisible by three returns "Fizz" and "POW"'() {

        given:
            def numberDivisibleByThree = 6
        when:
            def answer = extendedFizzBuzzer.getAnswer(numberDivisibleByThree)
        then:
            answer == FIZZ + POW
    }


    def 'On integers containing number 3 returns answer containing "Pow'() {

        given:
            def integerContainingNumberThree = 35
        when:
            def answer = extendedFizzBuzzer.getAnswer(integerContainingNumberThree)
        then:
            answer.contains(POW)
    }


    def 'On integers containing number 5 returns answer containing "Mrru"'() {

        given:
            def integerContainingNumberFive = 35
        when:
            def answer = extendedFizzBuzzer.getAnswer(integerContainingNumberFive)
        then:
            answer.contains(MRRU)
    }


    def 'On integers divisible by five returns "BuzzMrru"'() {

        given:
            def integerDivisibleByFive = 10

        when:
            def answer = extendedFizzBuzzer.getAnswer(integerDivisibleByFive)

        then:
            answer == BUZZ + MRRU
    }


    def 'On integers divisible by three and five returns "FizzBuzzPowMrru"'(){

        given:
            def numberDivisibleByThreeAndFive = 15

        when:
            def answer = extendedFizzBuzzer.getAnswer(numberDivisibleByThreeAndFive)

        then:
            answer == FIZZ + BUZZ + POW + MRRU
    }


    def "On every 15th student bangAppender is invoked"() {

        given:
            def numberOfStudents = 32
            def irrelevantString = "someString"

            bangAppender.appendBangTo(_ as String) >> {
                return irrelevantString + BANG
            }

        when:
            for (int i = 1; i < numberOfStudents + 1; i++) {
                extendedFizzBuzzer.getAnswer(i)
            }

        then:
            2 * bangAppender.appendBangTo(_ as String)
    }

    def "BangAppender is not invoked before 15th student (bang threshold)"() {
        given:
            def numberOfStudents = 14
            def bangThreshold = numberOfStudents + 1
            def irrelevantString = "someString"

            def bangAppender = Mock(BangAppender)


            bangAppender.appendBangTo(_ as String) >> {
                return irrelevantString + BANG
            }

            def secondExtendedFizzBuzzer = new ExtendedFizzBuzzer(bangAppender, bangThreshold, behaviorFactory.createBehaviorList())

        when:
            for (int i = 1; i < numberOfStudents + 1; i++) {
                secondExtendedFizzBuzzer.getAnswer(i)
            }

        then:
             0 * bangAppender.appendBangTo(_ as String)
    }

}

