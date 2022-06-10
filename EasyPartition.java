public class EasyPartition {
    public static void main(String[] args) {
        int a = 3;
        EasyPartition ep = new EasyPartition();
        String res = ep.getPartition(a);
        System.out.println(res);
    }

    public String getPartition(int N) {
        int[] arr = new int[2 * N];
        for (int i = 0; i < 2 * N; i++)
            arr[i] = i + 1;
        int sum = 0;
        boolean jump = false;
        for (int x : arr)
            sum += x;
        for (int i = 2 * N - 1; i >= 0; i--) {
            if (jump) {
                break;
            }
            int lim = 8 * N - (2 * N - 1 - i);
            while (arr[i] < lim) {
                arr[i]++;
                sum++;
                if (sum == 4 * N * N) {
                    jump = true;
                    break;
                }
            }
        }
        boolean[] rest = new boolean[8 * N + 1];
        for (int x : arr)
            rest[x] = true;
        String res = "";
        for (int i = 1; i <= 8 * N; i++) {
            if (rest[i])
                res += 1;
            else
                res += 0;
        }
        return res;
    }
}