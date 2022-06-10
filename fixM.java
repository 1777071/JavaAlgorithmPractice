public class fixM {
    public static void main(String[] args) {
        String start = "4?*47=1974";
        fixM fm = new fixM();
        int result = fm.findDigit(start);
        System.out.println(result);
    }

    public int findDigit(String equation) {
        int indexj = 0;
        int indexe = 0;
        int indexq = 0;
        for (int i = 0; i < equation.length(); i++) {
            char sm = equation.charAt(i);
            if (sm == '=') {
                indexe = i;
            }
            if (sm == '?') {
                indexq = i;
            }
            if (sm == '*') {
                indexj = i;
            }
        }
        if (indexq > indexe) {
            String middle = "";
            String middle1 = "";
            for (int i = 0; i < indexj; i++) {
                middle += equation.charAt(i);
            }
            for (int i = indexj + 1; i < indexe; i++) {
                middle1 += equation.charAt(i);
            }
            int middleRe1 = Integer.parseInt(middle);
            int middleRe2 = Integer.parseInt(middle1);
            int resulta = middleRe1 * middleRe2;
            String middle2 = String.valueOf(resulta);
            return middle2.charAt(indexq - indexe - 1) - '0';
        } else {
            if (indexq > indexj) {
                String middle = "";
                String middle1 = "";
                for (int i = 0; i < indexj; i++) {
                    middle += equation.charAt(i);
                }
                for (int i = indexe + 1; i < equation.length(); i++) {
                    middle1 += equation.charAt(i);
                }
                int middleRe1 = Integer.parseInt(middle);
                int middleRe2 = Integer.parseInt(middle1);
                int resulta = middleRe2 / middleRe1;
                String middle2 = String.valueOf(resulta);
                String middle3 = "";
                for (int i = indexj + 1; i < indexe; i++) {
                    middle3 += equation.charAt(i);

                }
                if (middle2.length() < middle3.length()) {
                    return -1;
                } else {
                    if (resulta * middleRe1 != middleRe2) {
                        return -1;
                    }
                    return middle2.charAt(indexq - indexj - 1) - '0';
                }
            } else {
                String middle = "";
                String middle1 = "";
                for (int i = indexe + 1; i < equation.length(); i++) {
                    middle1 += equation.charAt(i);
                }
                for (int i = indexj + 1; i < indexe; i++) {
                    middle += equation.charAt(i);
                }
                int middleRe1 = Integer.parseInt(middle);
                int middleRe2 = Integer.parseInt(middle1);
                int resulta = middleRe2 / middleRe1;
                String middle2 = String.valueOf(resulta);
                String middle3 = "";
                for (int i = indexj + 1; i < indexe; i++) {
                    middle3 += equation.charAt(i);

                }
                if (middle2.length() < middle3.length()) {
                    return -1;
                } else {
                    if (resulta * middleRe1 != middleRe2) {
                        return -1;
                    }
                    return middle2.charAt(indexq) - '0';
                }
            }
        }

    }
}