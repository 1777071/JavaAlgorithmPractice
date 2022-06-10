import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class SRMcard {
    public static void main(String[] args) {
        int[] a = {353, 355, 121, 242, 238, 53, 52, 241, 236, 49, 240, 119, 50, 356, 124, 351, 123, 51, 122, 354, 54, 352, 237, 120, 239};
        SRMcard sc = new SRMcard();
        int result = sc.maxTurns(a);
        System.out.println(result);
    }

    public int maxTurns(int[] a) {
        Arrays.sort(a);
        int length = a.length - 1;
        int res = 0;
        while (length >= 0) {
            if (length > 0 && a[length - 1] + 1 == a[length]) {
                length--;
            }
            length--;
            res++;
        }
        return res;
    }

}