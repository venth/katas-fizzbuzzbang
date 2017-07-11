package factory.fizzbuzzer;

import java.util.List;

import appender.BangAppender;
import factory.behavior.ConditionalBehavior;
import fizzbuzzer.ExtendedFizzBuzzer;


public class ExtendedFizzBuzzerFactory implements AbstractExtendedFizzBuzzerFactory {

    private static ExtendedFizzBuzzerFactory instance;

    private ExtendedFizzBuzzerFactory(){}

    public static ExtendedFizzBuzzerFactory getInstance() {
        if (instance == null) {
            instance = new ExtendedFizzBuzzerFactory();
        }
        return instance;
    }

    @Override
    public ExtendedFizzBuzzer createExtendedFizzBuzzer(int bangThreshold, List<ConditionalBehavior> behaviorList) {
        BangAppender bangAppender = new BangAppender();
        return new ExtendedFizzBuzzer(bangAppender, bangThreshold, behaviorList);
    }
}
