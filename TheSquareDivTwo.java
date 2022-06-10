import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TheSquareDivTwo {
    public String[] solve(String[] b) {
        int n = b.length;
        int[] r = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i].charAt(j) == 'C') {
                    r[i]++;
                    count++;
                }
            }
        }
        String[] res = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = "";
            for (int j = n - 1; j >= 0; j--)
                if (r[j] > 0) {
                    r[j]--;
                    res[i] = 'C' + res[i];
                } else {
                    res[i] = '.' + res[i];
                }
        }
        return res;
    }


}