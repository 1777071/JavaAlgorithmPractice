public class NumberofFiboCalls {
    int[] b = {0, 0};

    public static void main(String[] args) {
        int a = 100;
        NumberofFiboCalls nfc = new NumberofFiboCalls();
        int[] b = nfc.fiboCal(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }


    public int[] fiboCal(int a) {
        int res = fib(a);
        return b;
    }

    public int fib(int a) {
        if (a == 0) {
            b[0]++;
            return 0;
        }
        if (a == 1) {
            b[1]++;
            return 1;
        }
        return fib(a - 1) + fib(a - 2);
    }

    public int[] fiboCallsMade(int n) {
        int[] o = new int[41];
        int[] z = new int[41];
        o[1] = 1;
        z[0] = 1;
        for (int i = 2; i <= 40; i++) {
            z[i] = z[i - 1] + z[i - 2];
            o[i] = o[i - 1] + o[i - 2];
        }
        return new int[]{z[n], o[n]};
    }
}
