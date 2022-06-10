import java.util.LinkedList;

public class DukeOnChessBoard {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    public String dukePath(int n, String init) {
        int[][] board = new int[n][n];
        boolean[][] used = new boolean[n][n];
        LinkedList<Pair> L = new LinkedList<Pair>();
        Pair qq = new Pair(init);
        L.add(qq);
        used[qq.y][qq.x] = true;
        String[] b = new String[n * n + 2];
        int bptr = 0;
        while (!L.isEmpty()) {
            Pair p = L.remove();
            b[bptr++] = p.toString();
            for (int k = 3; k >= 0; --k) {
                int x = p.x + dx[k];
                int y = p.y + dy[k];
                if (x < n && y < n && x >= 0 && y >= 0 && !used[y][x]) {
                    L.add(new Pair(x, y));
                    used[y][x] = true;
                    break;
                }
            }
        }
        String ans = "";
        for (int i = 0; i < bptr; ++i) {
            ans += (i == 0) ? b[i] : "-" + b[i];
        }
        //System.err.println(ans);
        if (ans.length() >= 40) {
            String tmp1 = ans.substring(0, 20);
            String tmp2 = ans.substring(ans.length() - 20, ans.length());
            ans = tmp1 + "..." + tmp2;
        }
        return ans;
    }

    public class Pair {
        int x, y;
        Pair prev;

        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
            prev = null;
        }

        public Pair(int xx, int yy, Pair pr) {
            x = xx;
            y = yy;
            prev = pr;
        }

        public Pair(String s) {
            x = s.charAt(0) - 'a';
            y = s.charAt(1) - '1';
            prev = null;
        }

        public String toString() {
            return (char) (x + 'a') + "" + (y + 1);
        }
    }

}
