package fizzbuzzer;

import appender.BangAppender;

public class ExtendedFizzBuzzer extends AbstractFizzBuzzer {

    private final String POW = "Pow";
    private final String MRRU = "Mrru";

    private final String STARTS_WITH_DIGITS = "^[0-9]{1,2}";

    private final String ENDS_WITH_LETTER = "[a-z]$";

    private final String CORRECTION_REGEX = STARTS_WITH_DIGITS + ".*" + ENDS_WITH_LETTER;

    private int studentIndex = 0;

    private int bangThreshold = 15;

    private BangAppender bangAppender;

    public ExtendedFizzBuzzer(BangAppender bangAppender, int bangThreshold){
        this.bangAppender = bangAppender;
        this.bangThreshold = bangThreshold;
    }

    public String getAnswer(int number){
        ++studentIndex;
        return appendBangToAnswerIfNecessary(getBaseAnswer(number));
    }

    private String getBaseAnswer(int number) {

        String numberAsString = String.valueOf(number);
        boolean isNumberDivisibleByThree = number % 3 == 0;
        boolean isNumberDivisibleByFive = number % 5 == 0;

        String answer = numberAsString;

        if (isNumberDivisibleByThree && isNumberDivisibleByFive) {
            return FIZZ + BUZZ + POW + MRRU;
        }

        boolean numberContainsThree = numberAsString.contains("3");
        boolean numberContainsFive = numberAsString.contains("5");

        if (isNumberDivisibleByFive) {
            answer = BUZZ;
        }

        if (isNumberDivisibleByThree) {
            answer = FIZZ;
        }

        if (numberContainsThree || isNumberDivisibleByThree) {
            answer = answer + POW;
        }

        if (numberContainsFive || isNumberDivisibleByFive) {
            answer = answer + MRRU;
        }

        return correctAnswerIfNecessary(answer);
    }

    private String correctAnswerIfNecessary(String answer) {

        boolean answerStartsWithDigitsAndEndsWithLetter = answer.matches(CORRECTION_REGEX);

        if (answerStartsWithDigitsAndEndsWithLetter) {
            return answer.replaceFirst("^[0-9]{1,2}", "");
        } else {
            return answer;
        }
    }

    private String appendBangToAnswerIfNecessary(String baseAnswer) {
        if (studentIndex % bangThreshold == 0) {
            studentIndex = 0;
            baseAnswer = bangAppender.appendBangTo(baseAnswer);
        }
        return baseAnswer;
    }
}
