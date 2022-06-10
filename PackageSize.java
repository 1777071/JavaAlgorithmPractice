import java.util.Arrays;
import java.util.*;

public class PackageSize {
    public static void main(String[] args) {
        int[] a = {15, 7, 2};
        int b = 53;
        PackageSize ps = new PackageSize();
        int result = ps.getMininmum(a, b);
        System.out.println(result);
    }

    public int cal(int[] a, int b) {
        int bags = 0;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        //System.out.println(b);
        boolean jump = true;

        while (true) {

            if (b < sum && b > 0) {
                break;
            }
            //System.out.println("++++++++++");
            if (b < 0) {
                return -1;
            } else {
                b -= a[0];
                bags++;
            }
        }

        while (jump) {
            for (int i = 0; i < a.length; i++) {
                if (b >= a[i] && (b - a[i] >= a[a.length - 1] || b - a[i] == 0)) {
                    b -= a[i];
                    bags++;
                }
            }
            if (b == 0 || b < a[a.length - 1]) {
                jump = false;
            }
        }

        //System.out.println(bags+" p============p "+b);
        if (b != 0) {
            return -1;
        }
        bags++;
        return bags;

    }

    public int getMininmum(int[] a, int b) {
        int[] order = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            order[i] = a[i];
        }
        int middle = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (order[j - 1] < order[j]) {
                    middle = order[j - 1];
                    order[j - 1] = order[j];
                    order[j] = middle;
                }
            }
        }
//        for(int i=0;i<order.length;i++){
//            System.out.println(order[i]);
//        }
        int lastBagNum = 0;
        int currentBagMum = 9999999;
        for (int i = 0; i < a.length; i++) {
            if (b == a[i]) {
                return 1;
            }
        }

        for (int i = 0; i < a.length; i++) {
            int mid = b - a[i];
            if (mid < 0) {
                return -1;
            }
            lastBagNum = cal(order, mid);
            //System.out.println(mid+"========="+lastBagNum);
            if (lastBagNum < currentBagMum && lastBagNum >= 0) {

                currentBagMum = lastBagNum;
            }
        }
        if (currentBagMum == 9999999) {
            return -1;
        }
        return currentBagMum;
    }
}