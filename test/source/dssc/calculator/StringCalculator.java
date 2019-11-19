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
            String candidates = numbers.substring(2, firstNewline);
            int start = 0;
            int next = candidates.indexOf("]");
            if (next == -1) {
                delimiter += "|" + candidates.substring(start, firstNewline - 2);
            }
            else {
                delimiter += "|" + candidates.substring(start + 1, next);
                start = next + 1;
                while (start < firstNewline - 2) {
                    next = candidates.indexOf("]", start);
                    if (next == -1) {
                        delimiter += "|" + candidates.substring(start + 1, firstNewline - 2);
                        break;
                    }
                    delimiter += "|" + candidates.substring(start + 1, next);
                    start = next + 1;
                }
            }
            System.out.println(delimiter);
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
