public class JumpFurther {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        JumpFurther jf = new JumpFurther();
        int result = jf.furthest(a, b);
        System.out.println(result);
    }

    public int furthest(int a, int b) {
        int res = 0;
        for (int i = 1; i <= a; i++) {
            res += i;
            if (res == b) {
                res--;
            }
        }
        return res;
    }
}