public class RedundantStrings {
    boolean str = false;

    public static void main(String[] args) {
        int a = 10;
        RedundantStrings rs = new RedundantStrings();
        int result = rs.howMany(a);
        System.out.println(result);
    }

    public int howMany(int n) {
        long[][] ret = new long[2][n + 1];
        ret[0][1] = 0;
        ret[1][1] = 2;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    ret[0][i] = ret[0][i] + ret[1][j];
                }
            }
            ret[1][i] = (long) (Math.pow((double) 2.0, (double) (i))) - ret[0][i];
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println("==========");
        }
        return (int) (ret[0][n]);
    }
}