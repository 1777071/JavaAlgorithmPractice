public class ImportsList {
    public int[] importsCount(String[] requires) {
        int N = requires.length;
        int[] r = new int[N];

        boolean[][] reqs = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String a = requires[i];
            for (int j = 0; j < N; j++) {
                if (a.charAt(j) == 'Y') {
                    reqs[i][j] = true;
                }
            }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (reqs[i][j] && reqs[i][k] && reqs[k][j]) {
                        reqs[i][j] = false;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int c = 0;
            for (int j = 0; j < N; ++j) {
                if (reqs[i][j])
                    c++;
            }
            r[i] = c;
        }

        return r;
    }
}