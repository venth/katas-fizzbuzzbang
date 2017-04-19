package factory;

import fizzbuzzer.ExtendedFizzBuzzer;

/**
 * Created by marcin on 19.04.17.
 */
public interface AbstractExtendedFizzBuzzerFactory {

    ExtendedFizzBuzzer createExtendedFizzBuzzer(int bangThreshold);

}
