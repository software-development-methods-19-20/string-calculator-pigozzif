package dssc.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.contains(",")) {
            numbers = numbers.replaceAll("\n", ",");
            Stream<String> tokens = Arrays.stream(numbers.split(","));
            return tokens.mapToInt(Integer::valueOf).sum();
        }
        else {
            return Integer.valueOf(numbers);
        }
    }
}
