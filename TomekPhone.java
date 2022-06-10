import java.util.Arrays;

public class TomekPhone {
    public int minKeystrokes(int[] occurences, int[] keySizes) {
        Arrays.sort(occurences);
        int ans = 0;
        int[] cur = new int[keySizes.length];
        Arrays.fill(cur, 0);
        for (int i = occurences.length - 1; i >= 0; i--) {
            int minValue = Integer.MAX_VALUE;
            int loc = -1;
            for (int j = 0; j < keySizes.length; j++)
                if (cur[j] < keySizes[j] && cur[j] < minValue) {
                    minValue = cur[j];
                    loc = j;
                }
            if (loc == -1) return -1;
            cur[loc]++;
            ans += cur[loc] * occurences[i];
        }
        return ans;
    }
}