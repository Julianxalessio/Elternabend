public class eval {
    public static void main(String[] args) {
        String input = "3+5*2-8/4.445";
        String result = calculate(input);
        System.out.println("Result: " + result);
    }

    public static String calculate(String input) {
        String[] tokens = input.split("(?<=[+\\-*/])|(?=[+\\-*/])");

        ArrayList<Float> zahlen = new ArrayList<>();
        char lastOperator = '+';

        for (String token : tokens) {
            if (token.matches("[+\\-*/]")) {
                lastOperator = token.charAt(0);
            } else {
                float number = Float.parseFloat(token);

                if (lastOperator == '+') {
                    zahlen.add(number);
                } 
                else if (lastOperator == '-') {
                    zahlen.add(-number);
                } 
                else if (lastOperator == '*') {
                    float last = zahlen.remove(zahlen.size() - 1);
                    zahlen.add(last * number);
                } 
                else if (lastOperator == '/') {
                    float last = zahlen.remove(zahlen.size() - 1);
                    if (number == 0) {
                        return "Fehler: Division durch 0";
                    }
                    zahlen.add(last / number);
                }
            }
        }

        // Am Ende alles addieren
        float result = 0;
        for (float zahl : zahlen) {
            result += zahl;
        }

        return String.valueOf(result);
    }
}
