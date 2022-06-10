import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Crossroads {
    public int[] getOut(int[] angles) {
        int n = angles.length;
        int[] temp = new int[100];
        int l = 0;
        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; i++)
            mark[i] = true;
        for (int i = 0; i < n; i++)
            if (mark[i]) {
                for (int j = i + 1; j < n; j++)
                    if (angles[j] > angles[i]) {
                        if (angles[i] < 180 - angles[j]) {
                            mark[i] = false;
                            break;
                        } else
                            mark[j] = false;
                    }
                if (mark[i]) {
                    temp[l] = i;
                    l++;
                }
            }
        int[] out = new int[l];
        for (int i = 0; i < l; i++)
            out[i] = temp[i];
        Arrays.sort(out);
        return out;
    }
}