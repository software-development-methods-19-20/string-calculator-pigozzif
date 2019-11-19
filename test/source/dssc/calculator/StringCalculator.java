package dssc.calculator;

import test.NegativeNumbersException;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;


public class StringCalculator {
    public static int add(String numbers) throws NegativeNumbersException {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int firstNewline = numbers.indexOf("\n");
            delimiter = numbers.substring(2, firstNewline);
            numbers = numbers.substring(firstNewline + 1);
        }
        String[] splitted = numbers.replaceAll("\n", delimiter).split(delimiter);
        IntStream tokens = Arrays.stream(splitted).mapToInt(Integer::valueOf);
        OptionalInt anyNegative = tokens.filter(x -> x < 0).findAny();
        if (anyNegative.isPresent()) {
            throw new NegativeNumbersException("Negatives not allowed " + anyNegative);
        }
        return Arrays.stream(splitted).mapToInt(Integer::valueOf).filter(x -> x <= 1000).sum();
    }
}
