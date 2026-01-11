public class ArithmeticExp {
    
    // tokenize("3.14 + 5 * (2.718 - 8)") doit produire : 
    // ['3.14', '+', '5', '*', '(', '2.718', '-', '8', ')']

    public static String[] tokenize(String exp) {
        String[] tokens = new String[exp.length()];
        for (int i = 0; i < exp.length(); i++) {
            tokens[i] = String.valueOf(exp.charAt(i));
        }
        return tokens;
    }

    public static void main(String[] args) {
        String[] tokens = tokenize("3.14 + 5 * (2.718 - 8)");
        for (String token : tokens) {
            System.out.print(token + " ");
        }
    }
}
