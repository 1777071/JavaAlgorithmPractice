public class WinterAndMandarins {
    public static void main(String[] args) {
        int[] a = {47, 1000000000, 1, 74};
        int b = 2;
        WinterAndMandarins wam = new WinterAndMandarins();
        int result = wam.getNumber(a, b);
        System.out.println(result);
    }

    public int getNumber(int[] b, int a) {
        int res = 99999999;
        for (int i = 0; i < b.length; i++) {
            for (int j = 1; j < b.length - i; j++) {
                if (b[j - 1] > b[j]) {
                    int tem = b[j - 1];
                    b[j - 1] = b[j];
                    b[j] = tem;
                }
            }
        }
        for (int i = 0; i < b.length + 1 - a; i++) {
            if ((b[i + a - 1] - b[i]) < res) {
                res = b[i + a - 1] - b[i];
            }
        }
        return res;

    }
}