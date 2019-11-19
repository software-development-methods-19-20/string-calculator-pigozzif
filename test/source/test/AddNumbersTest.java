package test;

import dssc.calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddNumbersTest {

    @Test
    void emptyString() throws NegativeNumbersException{
        assertEquals(0, StringCalculator.add(""));
        assertThat(StringCalculator.add(""), is(0));
    }

    @Test
    void oneNumber() throws NegativeNumbersException {
        assertThat(StringCalculator.add("1"), is(1));
    }

    @Test
    void twoNumbers() throws NegativeNumbersException {
        assertThat(StringCalculator.add("1,2"), is(3));
    }

    @Test
    void anyNumbers() throws NegativeNumbersException {
        Random random = new Random();
        int numNumbers = 100;
        int maxNum = 100;
        int num = random.nextInt(numNumbers + 1);
        int currNum = random.nextInt(maxNum + 1);
        String testString = String.valueOf(currNum);
        int sum = currNum;
        for (int i=0; i < num - 1; ++i) {
            currNum = random.nextInt(maxNum + 1);
            testString += "," + currNum;
            sum += currNum;
        }
        assertThat(StringCalculator.add(testString), is(sum));
    }

    @Test
    void newlineIsOK() throws NegativeNumbersException { assertThat(StringCalculator.add("1\n2,3"), is(6)); }

    @Test
    void anyDelimiter() throws NegativeNumbersException { assertThat(StringCalculator.add("//;\n1;2"), is(3)); }

    @Test
    void negativeNumbers() {
        try {
            StringCalculator.add("-1");
            fail();
        }
        catch (NegativeNumbersException e) {
            assertThat(e.getMessage(), startsWith("Negatives not allowed"));
        }
    }
}
