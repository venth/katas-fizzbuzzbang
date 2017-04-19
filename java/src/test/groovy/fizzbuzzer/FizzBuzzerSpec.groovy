package fizzbuzzer

import fizzbuzzer.FizzBuzzer
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import spock.lang.Specification

class FizzBuzzerSpec extends Specification {

    def FIZZ = "Fizz"
    def BUZZ = "Buzz"

    FizzBuzzer fizzBuzzer = new FizzBuzzer()

    def 'On integers divisible by three returns "Fizz"'(){
        given:
            def numberDivisibleByThree = 6
        when:
            def answer = fizzBuzzer.getAnswer(numberDivisibleByThree)
        then:
            assert(answer == FIZZ)
    }

    def 'On integers divisible by five returns "Buzz"'(){
        given:
            def numberDivisibleByFive = 10
        when:
            def answer = fizzBuzzer.getAnswer(numberDivisibleByFive)
        then:
            assert(answer == BUZZ)
    }

    def 'On integers divisible by three and five returns "FizzBuzz"'(){
        given:
            def numberDivisibleByThreeAndFive = 15
        when:
            def answer = fizzBuzzer.getAnswer(numberDivisibleByThreeAndFive)
        then:
            assert(answer == FIZZ + BUZZ)
    }
}