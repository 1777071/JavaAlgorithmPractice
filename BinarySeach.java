/**/
import java.util.*;

import static java.lang.Math.*;
import static java.lang.Character.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Long.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class BinarySeach {
    int n, m, len;
    int ret;

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 10, 23, 22, 21};
        BinarySeach bs = new BinarySeach();
        int result = bs.howMany(a);
        System.out.println(result);
    }


    public int howMany(int[] sequence) {
        n = sequence.length;
        for (int i = 0; i < n; i++)
            if (greater(sequence, i) && smaller(sequence, i))
                ret++;
        return ret;
    }

    public boolean greater(int[] seq, int k) {
        for (int i = k + 1; i < seq.length; i++)
            if (seq[i] < seq[k]) return false;
        return true;
    }

    public boolean smaller(int[] seq, int k) {
        for (int i = 0; i < k; i++)
            if (seq[i] > seq[k]) return false;
        return true;
    }

}
}