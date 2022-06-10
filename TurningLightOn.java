public class TurningLightOn {
    public static int minFlips(string[] board) {
        int n = board.Length;
        int m = board[0].Length();
        StringBuilder[] a = new StringBuilder[board.Length];
        for (int i = 0; i < board.Length; i++) {
            a[i] = new StringBuilder();
            a[i].Append(board[i]);
        }
        char x = board[n - 1][m - 1];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (a[i][j] != x) {
                    count++;
                    for (int k = 0; k <= i; k++)
                        for (int t = 0; t <= j; t++)
                            if (a[k][t] == '0')
                                a[k][t] = '1';
                            else
                                a[k][t] = '0';
                }
            }
        }
        if (x == '0') return count + 1;
        return count;
    }
}