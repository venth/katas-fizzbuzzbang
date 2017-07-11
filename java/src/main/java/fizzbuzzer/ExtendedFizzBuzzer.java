package fizzbuzzer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import appender.BangAppender;
import factory.behavior.ConditionalBehavior;

public class ExtendedFizzBuzzer {

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

        behaviors.forEach(behavior -> {
          if (behavior.testCondition(number)) {
              answerBuilder.append(fizzBuzzBang(number, behavior.getOperator()));
          }
        });

        return Optional.of(answerBuilder.toString())
                .filter(answer -> !answer.isEmpty())
                .orElse(String.valueOf(number));
    }

    private String fizzBuzzBang(int number, Function<Integer, String>... buzzers) {

        StringBuilder resultBuilder = new StringBuilder();

        Arrays.asList(buzzers).forEach(buzzer -> resultBuilder.append(buzzer.apply(number)));

        return resultBuilder.toString();

    }

    private String appendBangToAnswerIfNecessary(String baseAnswer) {
        if (studentIndex % bangThreshold == 0) {
            studentIndex = 0;
            baseAnswer = bangAppender.appendBangTo(baseAnswer);
        }
        return baseAnswer;
    }
}
