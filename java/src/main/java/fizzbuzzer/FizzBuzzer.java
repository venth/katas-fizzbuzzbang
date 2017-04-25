package fizzbuzzer;

/**
 * Created by marcin on 18.04.17.
 */
public class FizzBuzzer extends AbstractFizzBuzzer {

    public String getAnswer(int number) {
        boolean isNumberDivisibleByThree = number % 3 == 0;
        boolean isNumberDivisibleByFive = number % 5 == 0;

        if (isNumberDivisibleByThree && isNumberDivisibleByFive) {
            return  FIZZ + BUZZ;
        } else if (isNumberDivisibleByFive) {
            return BUZZ;
        } else if (isNumberDivisibleByThree) {
            return FIZZ;
        } else {
            return String.valueOf(number);
        }
    }
}
