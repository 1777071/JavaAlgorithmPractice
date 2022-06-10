public class TravellingSalesmanEasy {
    public static void main(String[] args) {
        int a = 2;
        int[] b = {3, 10};
        int[] c = {1, 1};
        int[] d = {2, 1};

        TravellingSalesmanEasy tse = new TravellingSalesmanEasy();
        int result = tse.getMaxProfit(a, b, c, d);
        System.out.println(result);
    }

    public int getMaxProfit(int a, int[] b, int[] c, int[] d) {
        boolean[] visited = new boolean[c.length];
        int res = 0;
        for (int i = 0; i < d.length; i++) {

            int index = -1;
            int get = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[j] == d[i] && !visited[j]) {
                    if (get < b[j]) {
                        index = j;
                        get = b[j];
                    }
                }

            }
            if (get != -1) {
                res += get;
                visited[get] = true;
            }
        }
        return res
    }
}