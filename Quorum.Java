import java.util.ArrayList;

public class Quorum {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        int[] a = {50, 2, 9, 49, 38};
        int b = 3;
        Quorum qr = new Quorum();
        int result = qr.count(a, b);
        System.out.println(result);
    }

    public int count(int[] a, int b) {
        for (int i = 0; i < a.length; i++) {
            arrayList.add(a[i]);
        }
        int res = 0;
        int start = 9999999;
        int index = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (start > arrayList.get(j)) {
                    start = arrayList.get(j);
                    index = j;
                }
            }
            res += start;
            System.out.println(start + "===========");
            start = 9999999;
            arrayList.remove(index);
            index = 0;
        }
        return res;
    }
}