package factory.behavior;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by marcin on 24.04.17.
 */
public class ConditionalBehavior {

    private Predicate<Integer> condition;

    private Function<Integer, String> operator;

    public ConditionalBehavior(Predicate<Integer> condition, Function<Integer, String> operator) {
        this.condition = condition;
        this.operator = operator;
    }

    public Predicate<Integer> getCondition() {
        return condition;
    }

    public void setCondition(Predicate<Integer> condition) {
        this.condition = condition;
    }

    public Function<Integer, String> getOperator() {
        return operator;
    }

    public void setOperator(Function<Integer, String> operator) {
        this.operator = operator;
    }

    public boolean testCondition(Integer number) {
        return condition.test(number);
    }

}
