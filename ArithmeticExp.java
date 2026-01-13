import java.util.*;
import java.util.Stack;

public class ArithmeticExp {

    public static void main(String[] args) {
        ArrayList<String> tokens;
        String exp =  "3.14 + 5 * (2.718 - 8)"; // => [3.14, +, 5, *, (, 2.718, -, 8, )]
//        tokens = tokenize(exp);                 // => [3.14, 5, 2.718, 8, -, *, +]
//        System.out.println(tokens);
        tokens = infixeToPostfixe(exp);
        System.out.println(tokens);
    }

    public static ArrayList<String> tokenize(String exp) {
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        int length = exp.length();
        for (int i = 0; i < length; i++) {
            char c = exp.charAt(i);
            // if there is dot . build the number
            if (Character.isDigit(c) || c =='.') {
                number.append(c);
            } else {
                // end of number
                if (!number.isEmpty()) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                // ignore spaces
                if (c != ' ') {
                    // for negative number
                    if (c == '-' && shouldTreatAsNegative(tokens)) {
                        number.append(c);
                    } else {
                        tokens.add(String.valueOf(c));
                    }
                }
            }
        }
        // add the last number if it exists
        if (!number.isEmpty()) tokens.add(number.toString());
        return tokens;
    }

    private static boolean shouldTreatAsNegative(ArrayList<String> tokens) {
            if (tokens.isEmpty()) return true;
            String last = tokens.getLast();
            // after an operator or open parentheses
            return last.equals("+") || last.equals("-") ||
                last.equals("*") || last.equals("/") ||
                last.equals("^") || last.equals("(");
        }

    public static ArrayList<String> infixeToPostfixe(String exp) {
        ArrayList<String> tokens = tokenize(exp);
        ArrayList<String> output = new ArrayList<>();  // NEW output list
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                // What should you do with numbers?
                output.add(token); // add it directly in our list
            } else if (isOperator(token)) {
                // Pop operators with higher/equal precedence
                // Then push current operator
                while (!stack.isEmpty() &&
                        !stack.peek().equals("(") &&
                        calculPriorities(stack.peek()) >= calculPriorities(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                // What to do with opening parenthesis?
                stack.push(token);
            } else if (token.equals(")")) {
                // Pop until you find matching '('
                while (!stack.isEmpty() && !Objects.equals(stack.peek(), "(")) {
                    output.add(stack.pop());
                }
                stack.pop();
            }
        }
        // CORRECTION HERE: Pop elements one by one
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
    }

//    private static boolean isOperator(String token) {
//        return "+".equals(token) ||
//                "-".equals(token) ||
//                "*".equals(token) ||
//                "/".equals(token);
//    }

    private static final Set<String> OPERATORS =
            Set.of("+", "-", "*", "/");

    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }
    private static final Map<String, Integer> PRIORITIES =
            Map.of("+", 1, "-", 1, "*", 2, "/", 2);
    private static int calculPriorities(String op) {
        if (PRIORITIES.containsKey(op)) return PRIORITIES.get(op);
        return 0;
    }
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}