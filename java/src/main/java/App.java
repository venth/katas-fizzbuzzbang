import factory.ExtendedFizzBuzzerFactory;
import fizzbuzzer.ExtendedFizzBuzzer;
import fizzbuzzer.FizzBuzzer;

/**
 * Created on 27/02/2017.
 */
public class App {

    private static final int BANG_THRESHOLD = 15;

    public static void main(String[] args) {
        FizzBuzzer fizzBuzzer = new FizzBuzzer();
        for (int i = 1; i < 101; i++){
            System.out.println(fizzBuzzer.getAnswer(i));
        }

        System.out.println("================");

        ExtendedFizzBuzzer extendedFizzBuzzer = createExtendedFizzBuzzer();

        for (int i = 1; i < 101; i++) {
            System.out.println(extendedFizzBuzzer.getAnswer(i));
        }

    }

    private static ExtendedFizzBuzzer createExtendedFizzBuzzer() {
        ExtendedFizzBuzzerFactory extendedFizzBuzzerFactory = ExtendedFizzBuzzerFactory.getInstance();
        return extendedFizzBuzzerFactory.createExtendedFizzBuzzer(BANG_THRESHOLD);
    }



}
