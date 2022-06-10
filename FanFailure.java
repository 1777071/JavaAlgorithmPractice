View FanFailure Problem Statement
import java.util.*;
import java.lang.*;

public class FanFailure {
    public int[] getRange(int[] capacities, int minCooling) {
        Arrays.sort(capacities);
        int cooling = 0;
        int maxFS = 0;
        if (minCooling == 0) {
            int[] arr = new int[2];
            Arrays.fill(arr, capacities.length);
            return arr;
        }
        for (int i = capacities.length - 1; i >= 0; i--) {
            cooling += capacities[i];
            if (cooling >= minCooling) {
                maxFS = i;
                break;
            }
        }

        int maxc = 0;
        cooling = 0;
        for (int i = 0; i < capacities.length; i++) {
            cooling += capacities[i];
            if (cooling >= minCooling) {
                maxc = capacities.length - i - 1;
                break;
            }
        }
        int[] res = new int[2];
        res[0] = maxFS;
        res[1] = maxc;
        return res;
    }
}