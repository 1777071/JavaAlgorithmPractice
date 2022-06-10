public class PipePuzzle {
    public static void main(String[] args) {
        int[] a = {5, 6, 3, 9, -1};
        int b = 2;
        PipePuzzle pp = new PipePuzzle();
        int[] res = pp.derSeq(a, b);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] derSeq(int[] a, int b) {
        if (a.length == 1) {
            return a;
        } else {

            int[] mid = new int[a.length - 1];
            int index = 0;
            for (int i = 1; i < a.length; i++) {
                mid[index] = a[i] - a[i - 1];
                index++;
            }
            if (b == 1) {
                return mid;
            } else {
                return derSeq(mid, b - 1);
            }


        }
    }

}