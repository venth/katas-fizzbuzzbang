package factory.fizzbuzzer;

import java.util.Map;
import java.util.function.Predicate;

import fizzbuzzer.ExtendedFizzBuzzer;

/**
 * Created by marcin on 19.04.17.
 */
public interface AbstractExtendedFizzBuzzerFactory {

    ExtendedFizzBuzzer createExtendedFizzBuzzer(int bangThreshold, Map<Predicate<Integer>, String> behaviorMap);

}
