import java.math.*;
import java.util.*;

import static java.util.Arrays.*;
import static java.lang.Math.*;

public class SeventhPowers {
    public static void main(String[] args) {
        int a = 43740;
        SeventhPowers sp = new SeventhPowers();
        String result = sp.reconstructA(a);
        System.out.println(result);
    }

    public String reconstructA(int b) {
        int[] mid = new int[10];
        String res = "";
        for (int i = 0; i < 10; i++) {
            mid[i] = (int) pow(i, 7);
        }
        while (b != 0) {
            for (int i = 9; i > 0; i--) {
                if (b >= mid[i]) {
                    b -= mid[i];
                    res += String.valueOf(i);
                    break;
                }
            }
        }
        return res;
    }
}