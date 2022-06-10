public class EmoticonD {
    public static void main(String[] args) {
        int a = 1000;
        EmoticonD ed = new EmoticonD();
        int result = ed.printSmiles(a);
        System.out.println(result);
    }

    public int printSmiles(int a) {
        if (a <= 2) {
            return 2;
        } else {
            int maxv = a;
            int result = 0;
            int index = 0;
            for (int i = 2; i < a; i++) {
                if (i == maxv) {
                    continue;
                }
                if (maxv % i == 0) {
                    maxv = maxv / i;
                    index = i;
                    break;
                }
            }
            if (maxv == a && maxv != 1) {
                return a;
            }
            result = index + printSmiles(maxv);
            return result;
        }
    }

}
