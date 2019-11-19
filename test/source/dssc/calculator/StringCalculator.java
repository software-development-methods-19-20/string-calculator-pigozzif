package dssc.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.contains(",")) {
            //String[] tokens = numbers.split(",");
            Stream<String> tokens = Arrays.stream(numbers.split(","));
            return tokens.mapToInt(Integer::valueOf).sum();
            //return Integer.valueOf(tokens[0]) + Integer.valueOf(tokens[1]);
        }
        else {
            return Integer.valueOf(numbers);
        }
    }
}
