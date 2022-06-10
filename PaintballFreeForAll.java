import java.util.Arrays;
import java.math.BigInteger;


public class PaintballFreeForAll {
    int res = 1;
    String a;


    public static void main(String[] args) {
        int a = 1;
        int b = 7000;
        PaintballFreeForAll pff = new PaintballFreeForAll();
        int result = pff.winner(a, b);
        System.out.println(result);
    }

    public int winner(int N, int P) {
        final int MOD = (int) (1e9 + 7);
        BigInteger BMOD = BigInteger.valueOf(MOD);

        int[] inv = new int[N + 1];
        for (int i = 1; i < inv.length; i++) {
            inv[i] = BigInteger.valueOf(i).modInverse(BMOD).intValue();
        }

        int pHit = (int) (P * BigInteger.valueOf(10000).modInverse(BMOD).longValue() % MOD);

        // Transition probability.
        int[][] t = new int[N + 1][N + 1];
        for (int n = 2; n <= N; n++) {
            int[][] d = new int[n + 1][n + 1];
            int[][] nd = new int[n + 1][n + 1];
            d[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int[] arr : nd) {
                    Arrays.fill(arr, 0);
                }

                // Killed among the ones who shot.
                for (int a = 0; a <= i; a++) {
                    // Killed among the ones who did not shoot yet.
                    for (int b = 0; b <= n - i; b++) {
                        if (b == n - i) {
                            // All the future shooters are dead anyway, pick any.
                            int nb = b - 1;
                            long pNew = (long) (i - a) * inv[n - 1] % MOD * pHit % MOD;
                            long pOld = 1 - pNew;
                            if (pOld < 0) {
                                pOld += MOD;
                            }
                            if (a + 2 <= n) {
                                nd[a + 2][nb] = (int) ((nd[a + 2][nb] + pNew * d[a][b]) % MOD);
                            }
                            nd[a + 1][nb] = (int) ((nd[a + 1][nb] + pOld * d[a][b]) % MOD);
                            continue;
                        }

                        // Always pick a non-dead shooter otherwise (we will have to if none are dead anyway).
                        long pNewA = (long) (i - a) * inv[n - 1] % MOD * pHit % MOD;
                        long pNewB = (long) (n - i - b - 1) * inv[n - 1] % MOD * pHit % MOD;
                        long pOld = (1 - pNewA - pNewB) % MOD;
                        if (pOld < 0) {
                            pOld += MOD;
                        }
                        nd[a + 1][b] = (int) ((nd[a + 1][b] + pNewA * d[a][b]) % MOD);
                        nd[a][b + 1] = (int) ((nd[a][b + 1] + pNewB * d[a][b]) % MOD);
                        nd[a][b] = (int) ((nd[a][b] + pOld * d[a][b]) % MOD);
                    }
                }

                int[][] tmp = d;
                d = nd;
                nd = tmp;
            }

            for (int a = 0; a <= n; a++) {
                t[n][n - a] = d[a][0];
            }
        }

        long[] q = new long[N + 1];
        q[0] = 0;
        q[1] = 1;
        for (int n = 2; n <= N; n++) {
            long num = 0;
            for (int k = 0; k < n; k++) {
                num = (num + q[k] * t[n][k]) % MOD;
            }
            long denom = (1 - t[n][n]) % MOD;
            if (denom < 0) {
                denom += MOD;
            }
            q[n] = num * BigInteger.valueOf(denom).modInverse(BMOD).longValue() % MOD;
        }
        return (int) q[N];
    }
}