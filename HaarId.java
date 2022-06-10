import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HaarId {
    public static void main(String[] args) {
        int[] a = {94, 47, 46, 28, 39, 89, 75, 4, 28, 62, 69, 89, 34, 55, 81, 24};
        int b = 2;
        HaarId hi = new HaarId();
        int[] result = hi.transform(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] transform(int[] a, int b) {
        int[] mid = new int[a.length];
        if (b == 1) {
            int index1 = 0;
            for (int i = 0; i < a.length; i = i + 2) {
                mid[index1] = a[i] + a[i + 1];
                index1++;
            }
            for (int i = 0; i < a.length; i = i + 2) {
                mid[index1] = a[i] - a[i + 1];
                index1++;
            }
            return mid;
        } else {
            int index = 0;
            for (int i = 0; i < a.length; i = i + 2) {
                mid[index] = a[i] + a[i + 1];
                index++;
            }
            for (int i = 0; i < a.length; i = i + 2) {
                mid[index] = a[i] - a[i + 1];
                index++;
            }
            int[] midd = new int[a.length / 2];
            int[] middle = new int[a.length / 2];
            int number = b - 1;
            int indexa = 0;
            for (int i = 0; i < a.length / 2; i++) {
                midd[indexa] = mid[i];
                indexa++;
            }
            indexa = 0;
            for (int i = a.length / 2; i < a.length; i++) {
                middle[indexa] = mid[i];
                indexa++;

            }
            indexa = 0;
            for (int i = 0; i < midd.length; i++) {
                System.out.println(midd[i] + "+++");
            }
            midd = transform(midd, number);
            for (int i = 0; i < midd.length; i++) {
                System.out.println(midd[i] + "======");
            }
            int indexb = 0;
            for (int i = 0; i < midd.length; i++) {
                mid[indexb] = midd[i];
                indexb++;
            }
            for (int i = 0; i < middle.length; i++) {
                mid[indexb] = middle[i];
                indexb++;
            }
            return mid;
        }
    }
}