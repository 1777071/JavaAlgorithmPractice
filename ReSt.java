public class ReSt {
    public static void main(String[] args) {
        String middle = "ABAA";
        ReSt rs = new ReSt();
        int result = rs.longestLength(middle);
        System.out.println(result);

    }

    public int longestLength(String s) {
        int result = 0;
        int max = 0;
        String middle = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                middle += s.charAt(j);

                if (check(middle)) {
                    result = j - i + 1;

                }
                if (result > max) {
                    max = result;
                }
            }
            middle = "";
            result = 0;
        }
        return max;
    }

    public boolean check(String a) {
        String result = "";
        for (int i = a.length() - 1; i > -1; i--) {
            result += a.charAt(i);
        }

        if (result.equals(a)) {
            return true;
        } else {
            return false;
        }
    }
}