package factory;

import appender.BangAppender;
import fizzbuzzer.ExtendedFizzBuzzer;

/**
 * Created by marcin on 19.04.17.
 */
public class ExtendedFizzBuzzerFactory implements AbstractExtendedFizzBuzzerFactory {


    private static ExtendedFizzBuzzerFactory instance;

    private ExtendedFizzBuzzerFactory(){

    }

    public static ExtendedFizzBuzzerFactory getInstance() {
        if (instance == null) {
            instance = new ExtendedFizzBuzzerFactory();
        }
        return instance;
    }

    @Override
    public ExtendedFizzBuzzer createExtendedFizzBuzzer(int bangThreshold) {
        BangAppender bangAppender = new BangAppender();
        return new ExtendedFizzBuzzer(bangAppender, bangThreshold);
    }
}
