public class NinePuzzle {
    public int getMinimumCost(String init, String goal) {
        int[] s = new int[4];
        int[] e = new int[4];
        for (int i = 0; i < 10; i++) {
            if (init.charAt(i) == 'R')
                s[0]++;
            if (init.charAt(i) == 'G')
                s[1]++;
            if (init.charAt(i) == 'B')
                s[2]++;
            if (init.charAt(i) == 'Y')
                s[3]++;
            if (goal.charAt(i) == 'R')
                e[0]++;
            if (goal.charAt(i) == 'G')
                e[1]++;
            if (goal.charAt(i) == 'B')
                e[2]++;
            if (goal.charAt(i) == 'Y')
                e[3]++;
        }
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            if (e[i] - s[i] > 0) ret += e[i] - s[i];
        }
        return ret;
    }
}