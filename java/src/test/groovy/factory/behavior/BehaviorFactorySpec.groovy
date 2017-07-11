package factory.behavior

import spock.lang.Specification

class BehaviorFactorySpec extends Specification {

    def 'There is only one instance of BehaviorFactory'() {
        when:
            def firstFactoryReference = AppenderBehaviorFactory.getInstance()
            def secondFactoryReference = AppenderBehaviorFactory.getInstance()
        then:
            firstFactoryReference == secondFactoryReference
    }

    def 'ExtendedFizzBuzzerFacory creates BehaviorMaps'() {
        given:
            def behaviorFactory = AppenderBehaviorFactory.getInstance()
        when:
            def createdBehaviorList = behaviorFactory.createBehaviorList()
        then:
             createdBehaviorList instanceof List<ConditionalBehavior>
    }

}
