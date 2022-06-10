public class BlackAndWhite {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int[] c = {2, 2};
        BlackAndWhite waw = new BlackAndWhite();
        int result = waw.GetNumber(c, a, b);
        System.out.println(result);
    }

    public int GetNumber(int[] a, int b, int c) {
        int mod = 1000000007;
        int allball = 0;
        for (int i = 0; i < a.length; i++) {
            allball += a[i];
        }
        int[] AllS = new int[allball];
    }
}
/*public class BlackAndWhiteBallsEasy {
    static int MOD = 1000000007;

    public int getNumber(int[] balls, int white, int black) {

        int all = 0;
        for (int i = 0; i < balls.length; ++i) {
            all += balls[i];
        }

        int a[] = new int[all];

        int cur = 0;
        for (int i = 0; i < balls.length; ++i) {
            for (int j = 0; j < balls[i]; ++j) {
                a[cur++] = i % 2;
            }
        }

        int f[] = new int[all + 1];
        f[0] = 1;

        for (int i = 0; i < all; ++i) {
            int countwhite = 0, countblack = 0;
            for (int j = i; j < all; ++j) {
                if (a[j] == 0) ++countwhite;
                else ++countblack;

                if (countwhite == white) {
                    f[j + 1] += f[i];
                    f[j + 1] %= MOD;
                }
                if (countblack == black) {
                    f[j + 1] += f[i];
                    f[j + 1] %= MOD;
                }
            }
        }
        return f[all];
    }

}*/