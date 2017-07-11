package factory.fizzbuzzer;

import java.util.List;

import factory.behavior.ConditionalBehavior;
import fizzbuzzer.ExtendedFizzBuzzer;


public interface AbstractExtendedFizzBuzzerFactory {

    ExtendedFizzBuzzer createExtendedFizzBuzzer(int bangThreshold, List<ConditionalBehavior> behaviorList);

}
