package test;

import dssc.calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersTest {

    @Test
    void emptyString() {
        assertEquals(0, StringCalculator.add(""));
        assertThat(StringCalculator.add(""), is(0));
    }

    @Test
    void oneNumber() {
        assertThat(StringCalculator.add("1"), is(1));
    }

    @Test
    void twoNumbers() {
        assertThat(StringCalculator.add("1,2"), is(3));
    }

    @Test
    void anyNumbers() {
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
    void newlineIsOK() { assertThat(StringCalculator.add("1\n2,3"), is(6)); }

    @Test
    void anyDelimiter() { assertThat(StringCalculator.add("//;\n1;2"), is(3)); }
}
