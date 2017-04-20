package factory.behavior

import java.util.function.Predicate

import spock.lang.Specification

class BehaviorFactorySpec extends Specification {

    def 'There is only one instance of BehaviorFactory'() {
        when:
            def firstFactoryReference = BehaviorFactory.getInstance()
            def secondFactoryReference = BehaviorFactory.getInstance()
        then:
            firstFactoryReference == secondFactoryReference
    }

    def 'ExtendedFizzBuzzerFacory creates BehaviorMaps'() {
        given:
            def behaviorFactory = BehaviorFactory.getInstance()
        when:
            def createdBehaviorMap = behaviorFactory.createBehaviorMap()
        then:
             createdBehaviorMap instanceof Map<Predicate<Integer>, String>
    }

}
