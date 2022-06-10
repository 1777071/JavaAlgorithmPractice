public class Main {
    public static void main(String args[]) {
        String[] middle = {"20", "10", "+", "40", "*"};
        Main main1 = new Main();
        int res = main1.evalRPN(middle);
        System.out.println(res);
    }

    public int evalRPN(String[] tokens) {
        int number = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                number++;
            }
        }

        int[] location = new int[number];
        int j = 0;
        for (int i = 0; i < tokens.length; i++) {
            int a = 0;
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                a = i;
                location[j] = a;
                j++;
            }

        }

        int b = location[0];
        String a = tokens[b];
        int result1 = 0;
        switch (a) {
            case "+":

                result1 = Integer.parseInt(tokens[b - 2]) + Integer.parseInt(tokens[b - 1]);
                break;
            case "-":

                result1 = Integer.parseInt(tokens[b - 2]) - Integer.parseInt(tokens[b - 1]);
                break;
            case "*":

                result1 = (Integer.parseInt(tokens[b - 2])) * (Integer.parseInt(tokens[b - 1]));
                break;
            case "/":
                result1 = (Integer.parseInt(tokens[b - 2])) / (Integer.parseInt(tokens[b - 1]));
        }

        String result2 = String.valueOf(result1);

        int newlength = tokens.length - 3;
        if (newlength == 0) {
            return result1;
        } else {
            String[] finResult = new String[newlength + 1];
            int c = 0;
            for (int i = 0; i < tokens.length; i++) {

                if (i <= b && i >= b - 2) {
                    finResult[c] = result2;

                    continue;
                }
                if (finResult[c] == result2) {
                    c++;
                }
                finResult[c] = tokens[i];

                c++;
            }

            return evalRPN(finResult);
        }
    }
}

