import java.util.ArrayList;

public class IncreasingJumps {
    public static void main(String[] args) {
        int[] a = {5, 6, 1, 9, 8};
        IncreasingJumps ij = new IncreasingJumps();
        int[] result = ij.jump(a);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] jump(int[] frogs) {
        int n = frogs.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int init = frogs[i];
            int fin = i;
            int left = (i + 1) * -1;
            int right = (i + 1);
            if (fin < init) {
                int count = init - fin;
                while (count > 0) {
                    ans.add(right);
                    ans.add(left);
                    count--;
                }
            } else {
                int count = fin - init;
                while (count > 0) {
                    ans.add(left);
                    ans.add(right);
                    count--;
                }
            }
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }
}
