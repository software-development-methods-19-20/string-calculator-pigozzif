package dssc.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int firstNewline = numbers.indexOf("\n");
            delimiter = numbers.substring(2, firstNewline);
            numbers = numbers.substring(firstNewline + 1);
        }
        if (numbers.contains(delimiter)) {
            numbers = numbers.replaceAll("\n", delimiter);
            Stream<String> tokens = Arrays.stream(numbers.split(delimiter));
            return tokens.mapToInt(Integer::valueOf).sum();
        }
        else {
            return Integer.valueOf(numbers);
        }
    }
}
