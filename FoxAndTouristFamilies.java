import java.util.*;

public class FoxAndTouristFamilies {
    public double expectedLength(int[] A, int[] B, int[] f) {
        int n = A.length + 1;
        int m = f.length;
        double[][] probs = new double[m][n - 1];
        int[][] pres = new int[n][n];
        for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j) pres[i][j] = -1;
        for (int i = 0; i < n - 1; ++i) {
            int a = A[i], b = B[i];
            pres[a][b] = pres[b][a] = i;
        }
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j) {
                    if (pres[i][j] == -1 && pres[i][k] != -1 && pres[k][j] != -1) pres[i][j] = pres[i][k];
                }
        double unit = 1.0 / (n - 1);
        for (int ii = 0; ii < m; ++ii)
            for (int j = 0; j < n; ++j) {
                int i = f[ii];
                if (i == j) continue;
                int from = i, to = j;
                while (from != to) {
                    int k = pres[from][to]; //road
                    probs[ii][k] += unit;
                    int a = A[k], b = B[k];
                    if (a == from) from = b;
                    else from = a;
                }
            }

        double res = 0;
        for (int j = 0; j < n - 1; ++j) {
            double t = 1;
            for (int i = 0; i < m; ++i) { //System.out.println(Arrays.toString(probs[i]));
                t *= probs[i][j];
            }
            res += t;
        }
        return res;
    }
}