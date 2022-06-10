import java.util.ArrayList;

public class ReconstructPermutation {
    public static void main(String[] args) {
        int a = 5;
        int[] b = {3, 1, 4, 0, 2};
        ReconstructPermutation rsp = new ReconstructPermutation();
        int[] result = rsp.reconstruct(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] reconstruct(int a, int[] b) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            arrayList.add(b[i]);
        }
        int[] res = new int[a];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i]; j++) {
                if (arrayList.contains(j)) {
                    continue;
                } else {
                    arrayList.add(j);
                    res[index] = j;
                    index++;
                }
            }
            res[index] = b[i];
            index++;
        }
        for (int j = 0; j < a; j++) {
            if (arrayList.contains(j)) {
                continue;
            } else {
                arrayList.add(j);
                res[index] = j;
                index++;
            }
        }
        return res;
    }
}
