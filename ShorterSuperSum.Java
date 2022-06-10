public class ShorterSuperSum {
    public static void main(String[] args) {
        int a = 14;
        int b = 14;
        ShorterSuperSum sss = new ShorterSuperSum();
        int result = sss.calculate(a, b);
        System.out.println(result);
    }

    public int calculate(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            int result = 0;
            for (int i = 1; i <= b; i++) {
                result += calculate(a - 1, i);
            }
            return result;
        }
    }
}