public class ChristmasCrackerHappiness {
    public static void main(String[] args) {
        int a = 5;
        int[] b = {0, 1, 0, 3, 2, 0, 4, 0};
        int[] c = {3, 3, 4, 1, 0, 2, 1, 3};
        ChristmasCrackerHappiness cc = new ChristmasCrackerHappiness();
        int result = solve(a, b, c)
        System.out.println(result);
    }

    public int solve(int a, int[] b, int[] c) {
        int[] a = new int[N];
        int r = 0;
        for (int w : winner) {
            a[w] = 1;
        }
        for (int i = 0; i < N; i++) {
            r += a[i];
        }
        if (r >= N - 1) {
            return 0;
        }
        return N - 1 - r;
    }
}