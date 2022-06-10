public class PAndPun {
    public static void main(String[] args) {
        String a = "aaaa";
        PAndPun pp = new PAndPun();
        String result = pp.check(a);
        System.out.println(result);
    }

    public String check(String text) {
        String mid1 = "not a pun";
        if (text.length() < 4) {
            return "not a pun";
        } else {
            for (int i = 0; i < text.length() - 2; i++) {
                for (int j = i + 2; j < text.length(); j++) {
                    if (text.charAt(i) == (text.charAt(j))) {

                        if (j == text.length() - 1) {
                            return "not a pun";
                        } else {
                            if (text.charAt(i + 1) == (text.charAt(j + 1))) {
                                return "pun";
                            }
                        }
                    }
                }
            }
        }
        return mid1;
    }
}