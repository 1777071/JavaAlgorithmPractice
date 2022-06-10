public class lastexam1 {
    public static void main(String[] args) {
        long value = 76540123;
        lastexam1 last = new lastexam1();
        long result = last.smallestChange(value);
        System.out.println(result);
    }

    public int smallestChange(long cost) {
        int count = 0;
        long middle = cost;
        while (middle >= 1) {
            middle = middle / 10;
            count++;
        }
        if (count < 4) {
            long a = cost / 100;
            cost = cost % 100;
            long b = cost / 25;
            cost = cost % 25;
            long c = cost / 10;
            cost = cost % 10;
            long d = cost / 1;
            return (int) (a + b + c + d);
        } else {
            int tfw = count - 2;
            int tmv = 1;
            int tfmv = 25;
            boolean out = true;
            long acount = 0;
            for (int i = 1; i < count; i++) {
                tmv = 10 * tmv;
            }
            for (int i = 0; i < tfw; i++) {
                tfmv = 10 * tfmv;
            }
            while (out == true) {
                long a = 0;
                if (tfmv > tmv) {
                    a = cost / tfmv;
                    cost = cost % tfmv;
                    tfmv = tfmv / 100;
                } else {
                    a = cost / tmv;
                    cost = cost % tmv;
                    tmv = tmv / 10;
                }
                acount = acount + a;
                if ((tmv / 10) == 0) {
                    return (int) (acount + cost / 1);
                }


            }
        }
        return 0;
    }
}