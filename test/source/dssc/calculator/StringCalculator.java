package dssc.calculator;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.contains(",")) {
            String[] tokens = numbers.split(",");
            return Integer.valueOf(tokens[0]) + Integer.valueOf(tokens[1]);
        }
        else {
            return Integer.valueOf(numbers);
        }
    }
}
