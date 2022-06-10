public class StandInLine {
    public int[] reconstruct(int[] l) {
        int n = l.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int k = l[i];
            int j = 0;
            for (j = 0; j < n; j++) {
                if (res[j] != 0)
                    continue;
                if (k == 0)
                    break;
                k--;
            }
            res[j] = i + 1;
        }
        return res;
    }
}