public class MSN {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        MSN m = new MSN();
        int result = m.count(a, b);
        System.out.println(result);
    }

    public int count(a, b) {
        int res = 0;
        for (int i = a, i<=b;
        i++){
            if (cool(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean cool(int a) {
        String mid = String.valueOf(a);
        if (mid.length() < 2) {
            return false;
        } else {
            int[] midd = new int[mid.length()];
            for (int i = 0; i < mid.length(); i++) {
                midd[i] = mid.charAt(i) - 48;
            }
            if (midd.length == 2) {
                midd[0] == midd[1];
                return true;
            } else {

            }
            return false;
        }
    }

}