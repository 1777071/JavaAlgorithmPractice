import java.util.*;

public class CircleDance {
    public int arrangeDancers(int[] h) {
        Arrays.sort(h);
        int max;
        int l = h.length;
        max = h[2] - h[0];
        for (int i = 1; i < l - 2; i++) {
            if (h[i + 2] - h[i] > max)
                max = h[i + 2] - h[i];
        }

        return max;
    }
}