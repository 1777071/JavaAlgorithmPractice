import java.util.Arrays;
import java.util.Comparator;

public class FarmvilleDiv2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {5, 4, 3, 2, 1};
        int c = 15;
        FarmvilleDiv2 fd = new FarmvilleDiv2();
        int result = fd.minTime(a, b, c);
        System.out.println(result);
    }

    public int minTime(int[] time, int[] cost, int budget) {
        int res = 0;
        Pair[] p = new Pair[time.length];
        for (int i = 0; i < p.length; i++) {
            p[i] = new Pair();
            p[i].time = time[i];
            p[i].cost = cost[i];
            res += p[i].cost;
        }
        Pair mid;
        for (int i = 0; i < p.length; i++) {
            for (int j = 1; j < p.length - i; j++) {
                if (p[j - 1].cost > p[j].cost) {
                    mid = p[j - 1];
                    p[j - 1] = p[j];
                    p[j] = mid;
                }
            }
        }
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].cost + "=========" + p[i].time);
        }
        for (int i = 0; i < time.length; i++) {
            int amount = Math.min(budget / p[i].cost, p[i].time);
            System.out.println(amount);
            budget -= amount * p[i].cost;
            res -= amount;
        }
        return res;
    }

    static class Pair {
        int time;
        int cost;
    }
}