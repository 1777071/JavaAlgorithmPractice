public class PrimeSoccer {
    public static void main(String[] args) {
        int a = 50;
        int b = 50;
        PrimeSoccer ps = new PrimeSoccer();
        double result = ps.getProbability(a, b);
        System.out.println(result);
    }

    public double getProbability(int a, int b) {
        double rs1 = prob((double) a / 100.0);
        double rs2 = prob((double) b / 100.0);
        return rs1 + rs2 - rs1 * rs2;
    }

    public double prob(double a) {
        double[] dp = new double[19];
        dp[0] = 1;
        for (int i = 0; i < 18; i++) {
            for (int j = 18; j > 0; j--) {
                dp[j] = dp[j] * (1 - a) + dp[j - 1] * a;
            }
            dp[0] = dp[0] * (1 - a);
        }
        double res = 0.0;
        for (int i = 0; i < 18; i++) {
            if (Itis(i)) {
                res += dp[i];
            }
        }
        return res;
    }

    public boolean Itis(int i) {
        if (i <= 1) {
            return false;
        } else {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}