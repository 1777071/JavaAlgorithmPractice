import java.util.ArrayList;

public class OppositeParity {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        int[] a = {27, 18, 281, 828, 45, 90, 452, 3};
        OppositeParity op = new OppositeParity();
        int[] result = op.rearrange(a);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] rearrange(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arrayList.add(a[i]);
        }
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j) % 2 == 0) {
                        newList.add(arrayList.get(j));
                        arrayList.remove(j);
                        break;
                    }
                }
            } else {
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j) % 2 == 1) {
                        newList.add(arrayList.get(j));
                        arrayList.remove(j);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            res[i] = newList.get(i);
        }
        return res;
    }
}