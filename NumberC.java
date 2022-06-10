public class NumberC {
    boolean[] sum = new boolean[20000001];

    public static void main(String[] args) {
        int[] a = {5, 2, 1};
        NumberC nc = new NumberC();
        int result = nc.MinNumber(a);
        System.out.println(result);
    }

    public int MinNumber(int[] S) {
        MinNumber(S, 0, 0);
        for (int i = 1; i < sum.length; i++) {
            if (!sum[i]) return i;
        }
        return -1;
    }


    public void MinNumber(int[] S, int index, int total) {
        sum[total] = true;
        if (S.length <= index) return;
        MinNumber(S, index + 1, total + S[index]);
        MinNumber(S, index + 1, total);
    }
}