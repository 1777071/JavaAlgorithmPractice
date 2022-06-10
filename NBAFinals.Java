public class NBAFinals {
    public static void main(String[] args) {
        int[] a = {2, 2, 3, 3, 2, 4, 2};
        String b = "RRWWRWR";
        NBAFinals NF = new NBAFinals();
        int result = NF.dubsAgain(a, b);
        System.out.println(result);
    }

    public int dubsAgain(int[] a, int b) {
        int Rr = 0;
        int Wr = 0;
        for (int i = 0; i < a.length; i++) {
            if (R.charAt(i) == 'R') {
                if (a[i] > 0) {
                    Rr += a[i];
                } else {
                    Rr++;
                }
            } else {
                if (a[i] > 0) {
                    Wr += a[i];
                } else {
                    Wr += 4;
                }
            }
        }
        if (Wr > Rr) {
            return 1;
        } else {
            return 0;
        }
    }
}