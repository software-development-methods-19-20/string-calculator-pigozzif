package test;

import dssc.calculator.StringCalculator;
import org.junit.jupiter.api.Test;

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
}
