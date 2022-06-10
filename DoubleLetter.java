public class DoubleLetter {
    public static void main(String[] args) {
        String a = "aabccbb";
        DoubleLetter dl = new DoubleLetter();
        String result = dl.ableToSolve(a);
        System.out.println(result);
    }

    public String ableToSolve(String a) {
        int index = 0;
        String mid = a;
        boolean same = false;
        if (mid.equals("")) {
            return "possible";
        }
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == a.charAt(i + 1)) {
                index = i;
                same = true;
                break;
            }
        }
        if (!same) {
            return "impossible";
        } else {
            if (index + 2 <= mid.length()) {
                mid = mid.substring(0, index) + mid.substring(index + 2);
            } else {
                String middle = "";
                for (int i = 0; i < index; i++) {
                    middle += mid.charAt(i);
                }
                mid = middle;
            }
            return ableToSolve(mid);

        }

    }


}
