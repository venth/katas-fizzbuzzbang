package fizzbuzzer;

import java.util.List;
import java.util.function.Function;

import appender.BangAppender;
import factory.behavior.ConditionalBehavior;

public class ExtendedFizzBuzzer extends AbstractFizzBuzzer {

    private final String POW = "Pow";
    private final String MRRU = "Mrru";

    private int studentIndex = 0;

    private int bangThreshold = 15;

    private BangAppender bangAppender;

    private List<ConditionalBehavior> behaviors;



    public ExtendedFizzBuzzer(BangAppender bangAppender, int bangThreshold, List<ConditionalBehavior> behaviors){
        this.bangAppender = bangAppender;
        this.bangThreshold = bangThreshold;
        this.behaviors = behaviors;
    }

    public String getAnswer(int number){
        ++studentIndex;
        return appendBangToAnswerIfNecessary(getBaseAnswer(number));
    }

    private String getBaseAnswer(int number) {

        StringBuilder answerBuilder = new StringBuilder();

        boolean isNumberDivisibleByThree = number % 3 == 0;
        boolean isNumberDivisibleByFive = number % 5 == 0;

        String answer = "";

        if (isNumberDivisibleByThree && isNumberDivisibleByFive) {
            return FIZZ + BUZZ + POW + MRRU;
        }

        behaviors.forEach(behavior -> {
          if (behavior.testCondition(number)) {
              answerBuilder.append(fizzBuzzBang(number, behavior.getOperator()));
          }
        });

        String answerToReturn = answerBuilder.toString();
        if (answerToReturn.isEmpty()) {
            answerToReturn = String.valueOf(number);
        }

        return answerToReturn;
    }

    private String fizzBuzzBang(int number, Function<Integer, String> operator) {
        return operator.apply(number);
    }

    private String appendBangToAnswerIfNecessary(String baseAnswer) {
        if (studentIndex % bangThreshold == 0) {
            studentIndex = 0;
            baseAnswer = bangAppender.appendBangTo(baseAnswer);
        }
        return baseAnswer;
    }
}
