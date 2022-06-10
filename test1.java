public class test1 {
    public static void main(String args[]) {
        int[] a = {2, 2};
        test1 test0 = new test1();
        int[] b = new int[a.length];
        a = test0.getUnsorted(a);
        if (a.length == 1 && a[0] == 0) {
            System.out.println("{}");
        } else {
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
                System.out.print(b[i] + " ");
            }
        }

    }

    public int[] getUnsorted(int[] s) {
        boolean judge = true;
        int same = s[0];
        for (int i = 1; i < s.length; i++) {
            if (same != s[i]) {
                judge = false;
                break;
            }
        }
        if (s.length == 1 || judge == true) {
            int[] result = {0};
            return result;
        }
        int middle = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 1; j < s.length; j++) {
                if (s[j - 1] > s[j]) {
                    middle = s[j - 1];
                    s[j - 1] = s[j];
                    s[j] = middle;
                }

            }
        }
        int index = 0;
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] > s[i - 1]) {
                index = i;
                break;
            }
        }
        int middle0 = 0;
        middle0 = s[index - 1];
        s[index - 1] = s[index];
        s[index] = middle0;
        return s;
    }
}