import java.util.List;

import factory.behavior.AppenderBehaviorFactory;
import factory.behavior.ConditionalBehavior;
import factory.fizzbuzzer.ExtendedFizzBuzzerFactory;
import fizzbuzzer.ExtendedFizzBuzzer;


public class App {

    private static final int BANG_THRESHOLD = 15;

    public static void main(String[] args) {
        printOutAnswersForKata();
    }



    private static void printOutAnswersForKata() {
        List<ConditionalBehavior> behaviorList = createBehaviorList();

        ExtendedFizzBuzzer extendedFizzBuzzer = createExtendedFizzBuzzer(behaviorList);

        for (int i = 1; i < 101; i++) {
            System.out.println(extendedFizzBuzzer.getAnswer(i));
        }
    }

    private static List<ConditionalBehavior> createBehaviorList() {
        AppenderBehaviorFactory behaviorFactory = AppenderBehaviorFactory.getInstance();
        return behaviorFactory.createBehaviorList();
    }

    private static ExtendedFizzBuzzer createExtendedFizzBuzzer(List<ConditionalBehavior> behaviorList) {
        ExtendedFizzBuzzerFactory extendedFizzBuzzerFactory = ExtendedFizzBuzzerFactory.getInstance();
        return extendedFizzBuzzerFactory.createExtendedFizzBuzzer(BANG_THRESHOLD, behaviorList);
    }
}
