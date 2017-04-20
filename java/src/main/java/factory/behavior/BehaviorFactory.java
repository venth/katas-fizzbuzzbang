package factory.behavior;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public class BehaviorFactory implements AbstractBehaviorFactory{

    private static BehaviorFactory instance;

    private int BANG_THRESHOLD = 15;

    private BehaviorFactory() {}

    public static BehaviorFactory getInstance() {
        if (instance == null) {
            instance = new BehaviorFactory();
        }
        return instance;
    }

    @Override
    public Map<Predicate<Integer>, String> createBehaviorMap() {

        Map<Predicate<Integer>, String> behaviorMap = new HashMap<>();

        addPowCondition(behaviorMap);

        addMrruCondition(behaviorMap);

        return behaviorMap;
    }

    private void addPowCondition(Map<Predicate<Integer>, String> behaviorMap) {
        behaviorMap.put(number -> {
            boolean isNumberDivisibleByThree = number % 3 == 0;
            boolean doesNumberContainNumberThree = String.valueOf(number).contains("3");
            return isNumberDivisibleByThree || doesNumberContainNumberThree;
        }, "Pow");
    }

    private void addMrruCondition(Map<Predicate<Integer>, String> behaviorMap) {
        behaviorMap.put(number -> {
            boolean isNumberDivisibleByThree = number % 5 == 0;
            boolean doesNumberContainNumberThree = String.valueOf(number).contains("5");
            return isNumberDivisibleByThree || doesNumberContainNumberThree;
        }, "Mrru");
    }

}
