import java.util.*;

public class VocaloidsAndSongs {
    long MOD = 1000000007;
    long[][][][] memo;

    public static void main(String[] args) {
        int a = 18;
        int b = 12;
        int c = 8;
        int d = 9;
        VocaloidsAndSongs vas = new VocaloidsAndSongs();
        int result = vas.count(a, b, c, d);
        System.out.println(result);
    }

    public int count(int S, int gumi, int ia, int mayu) {
        memo = new long[S + 1][gumi + 1][ia + 1][mayu + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                for (int k = 0; k < memo[i][j].length; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        long res = go(S, gumi, ia, mayu);


        return (int) res;
    }

    private long go(int s, int n1, int n2, int n3) {
        if (memo[s][n1][n2][n3] != -1) {
            return memo[s][n1][n2][n3];
        }
        if (s == 0) {
            if (n1 == 0 && n2 == 0 && n3 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            long res = 0;

            if (n1 > 0) {
                res += go(s - 1, n1 - 1, n2, n3);
            }
            res %= MOD;
            if (n2 > 0) {
                res += go(s - 1, n1, n2 - 1, n3);
            }
            res %= MOD;
            if (n3 > 0) {
                res += go(s - 1, n1, n2, n3 - 1);
            }
            res %= MOD;
            if (n1 > 0 && n2 > 0) {
                res += go(s - 1, n1 - 1, n2 - 1, n3);
            }
            res %= MOD;
            if (n1 > 0 && n3 > 0) {
                res += go(s - 1, n1 - 1, n2, n3 - 1);
            }
            res %= MOD;
            if (n2 > 0 && n3 > 0) {
                res += go(s - 1, n1, n2 - 1, n3 - 1);
            }
            res %= MOD;
            if (n1 > 0 && n2 > 0 && n3 > 0) {
                res += go(s - 1, n1 - 1, n2 - 1, n3 - 1);
            }
            res %= MOD;

            return memo[s][n1][n2][n3] = res;
        }
    }
}