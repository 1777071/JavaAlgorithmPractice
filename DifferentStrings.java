import java.util.*;

public class DifferentStrings {
    static int r = 10000;

    public int minimize(String A, String B) {
        int d = 0;
        for (int k = 0; k < B.length() - A.length() + 1; k++) {
            d = difference(A, B.substring(k, k + A.length()));
            r = Math.min(r, d);
        }
        return r;
    }

    int difference(String A, String B) {
        int d = 0;
        for (int i = 0; i < A.length(); i++)
            if (A.charAt(i) != B.charAt(i))
                d++;
        return d;
    }
}