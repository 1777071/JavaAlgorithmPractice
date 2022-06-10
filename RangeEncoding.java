public class RangeEncoding {
    public static void main(String[] args) {
        int[] a = {10, 11, 12, 13, 14, 15, 20, 21, 22, 23, 25, 27, 28, 29, 30, 31, 32, 33};
        RangeEncoding re = new RangeEncoding();
        int result = re.minRanges(a);
        System.out.println(result);
    }

    public int minRanges(int[] a) {
        int res = 1;
        int counter = a[0];
        for (int i = 1; i < a.length; i++) {
            if ((counter + 1) == a[i]) {
                counter = a[i];
                continue;
            } else {
                res++;
                counter = a[i];
            }
        }
        return res;
    }
}