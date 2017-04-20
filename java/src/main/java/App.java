import java.util.Map;
import java.util.function.Predicate;

import factory.behavior.BehaviorFactory;
import factory.fizzbuzzer.ExtendedFizzBuzzerFactory;
import fizzbuzzer.ExtendedFizzBuzzer;
import fizzbuzzer.FizzBuzzer;


public class App {

    private static final int BANG_THRESHOLD = 15;

    public static void main(String[] args) {

        printOutAnswersForFirstPartOfKata();

        System.out.println("================");

        printOutAnswersForSecondPartOfKata();
    }

    private static void printOutAnswersForFirstPartOfKata() {
        FizzBuzzer fizzBuzzer = new FizzBuzzer();

        for (int i = 1; i < 101; i++){
            System.out.println(fizzBuzzer.getAnswer(i));
        }
    }

    private static void printOutAnswersForSecondPartOfKata() {
        Map<Predicate<Integer>, String> behaviorMap = createBehaviorMap();

        ExtendedFizzBuzzer extendedFizzBuzzer = createExtendedFizzBuzzer(behaviorMap);

        for (int i = 1; i < 101; i++) {
            System.out.println(extendedFizzBuzzer.getAnswer(i));
        }
    }

    private static Map<Predicate<Integer>, String> createBehaviorMap() {
        BehaviorFactory behaviorFactory = BehaviorFactory.getInstance();
        return behaviorFactory.createBehaviorMap();
    }

    private static ExtendedFizzBuzzer createExtendedFizzBuzzer(Map<Predicate<Integer>, String> behaviorMap) {
        ExtendedFizzBuzzerFactory extendedFizzBuzzerFactory = ExtendedFizzBuzzerFactory.getInstance();
        return extendedFizzBuzzerFactory.createExtendedFizzBuzzer(BANG_THRESHOLD, behaviorMap);
    }
}
