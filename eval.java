public class eval {
    public static void main(String[] args) {
        String input = "3+5*2-8/4.445";
        String result = calculate(input);
        System.out.println("Result: " + result);
    }

    public static String calculate(String input) {
        String[] tokens = input.split("(?<=[+\\-*/])|(?=[+\\-*/])");

        float result = 0;
        char lastOperator = '+';

        for (String token : tokens) {
            if (token.matches("[+\\-*/]")) {
                lastOperator = token.charAt(0);
            } else {
                float number = Float.parseFloat(token);

                if (lastOperator == '+') result += number;
                else if (lastOperator == '-') result -= number;
                else if (lastOperator == '*') result *= number;
                else if (lastOperator == '/') result /= number;
            }
        }

        return String.valueOf(result);
    }
}