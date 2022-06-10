import java.util.ArrayList;

public class LimitedDifferences {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        LimitedDifferences ld = new LimitedDifferences();
        int[] result = ld.arrange(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] arrange(int a, int b) {
        int[] res = new int[a];
        boolean e = true;
        update(a, b, 1, a, e);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + " ====");
        }
        for (int i = 0; i < a; i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public void update(int a, int b, int c, int d, boolean e) {
        if (b == 1) {
            if (e) {
                for (int i = c; i <= d; i++) {
                    arrayList.add(i);
                }
            } else {
                for (int i = d; i >= c; i--) {
                    arrayList.add(i);
                }
            }
        } else {
            if (e) {
                arrayList.add(c);
                update(a, b - 1, c + 1, d, !e);
            } else {
                arrayList.add(d);
                update(a, b - 1, c, d - 1, !e);
            }
        }
    }
}