package factory.behavior

import factory.fizzbuzzer.ExtendedFizzBuzzerFactory
import fizzbuzzer.ExtendedFizzBuzzer
import spock.lang.Specification


class ExtendedFizzBuzzerFactoryTest extends Specification {


    def 'There is only one instance of ExtendedFizzBuzzerFactory'() {
        when:
            def firstFactoryReference = ExtendedFizzBuzzerFactory.getInstance()
            def secondFactoryReference = ExtendedFizzBuzzerFactory.getInstance()
        then:
            firstFactoryReference == secondFactoryReference
    }

    def 'ExtendedFizzBuzzerFacory creates ExtendedFizzBuzzers'() {
        given:
            def extendedFizzBuzzerFacory = ExtendedFizzBuzzerFactory.getInstance()
            def irrelevantBangThreshold = 15
            def irrelevantBehaviorMap = Collections.emptyMap()
        when:
            def createdExtendedFizzBuzzer = extendedFizzBuzzerFacory.createExtendedFizzBuzzer(irrelevantBangThreshold, irrelevantBehaviorMap)
        then:
            createdExtendedFizzBuzzer instanceof ExtendedFizzBuzzer
    }

}
