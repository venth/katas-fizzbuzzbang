package factory.fizzbuzzer;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import factory.behavior.ConditionalBehavior;
import fizzbuzzer.ExtendedFizzBuzzer;

/**
 * Created by marcin on 19.04.17.
 */
public interface AbstractExtendedFizzBuzzerFactory {

    ExtendedFizzBuzzer createExtendedFizzBuzzer(int bangThreshold, List<ConditionalBehavior> behaviorList);

}
