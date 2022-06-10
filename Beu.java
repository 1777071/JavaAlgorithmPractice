public class Beu {
    public static void main(String[] args) {
        String middle = "ITHINKYOUAREAHUMAN";
        Beu be = new Beu();
        String result = be.solve(middle);
        System.out.println(result);
    }

    public String solve(String S) {
        String a = "possible";
        String b = "impossible";
        if (S.length() <= 2) {
            return b;
        } else {
            for (int i = 0; i < S.length() - 1; i++) {
                if (i == S.length() - 2) {
                    if (S.charAt(i) == S.charAt(i + 1)) {
                        return a;
                    }
                } else {
                    for (int j = i + 1; j < i + 3; j++) {
                        if (S.charAt(i) == S.charAt(j)) {
                            return a;
                        }
                    }
                }
            }
            return b;
        }
    }
}