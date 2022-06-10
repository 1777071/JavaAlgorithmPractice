public class Lunch {
    public static void main(String[] args) {
        int N = 11;
        int M = 30;
        int A = 4;
        int B = 7;
        int C = 1;
        int D = 2;
        int E = 3;
        Lunch lc = new Lunch();
        long result = lc.simulate(N, M, A, B, C, D, E);
        System.out.println(result);
    }

    public long simulate(int N, int M, int A, int B, int C, int D, int E) {
        int vis[] = new int[N];
        int K[] = new int[M];
        if (M > 0) K[0] = A;
        if (M > 1) K[1] = B;
        long n = N;
        for (int i = 2; i < M; ++i) {
            K[i] = (int) ((1l * C * K[i - 1] + 1l * D * K[i - 2] + E) % n);
        }
        long ans = 0;
        for (int i = M - 1; i >= 0; --i) {
            if (vis[K[i]] == 1) continue;
            vis[K[i]] = 1;
            --n;
            ans += n * K[i];
        }
        for (int i = N - 1; i >= 0; --i) {
            if (vis[i] == 0) {
                --n;
                ans += n * i;
            }
        }
        return ans;
    }
}