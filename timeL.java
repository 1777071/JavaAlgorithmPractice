public class timeL {
    public static void main(String[] args) {
        int[] good = {30, 20, 50, 10, 70, 40, 60};
        int[] bad = {91, 86, 71, 77, 71, 999, 314};
        timeL tl = new timeL();
        int result = tl.setTimeLimit(good, bad);
        System.out.println(result);

    }

    public int setTimeLimit(int[] goodTimes, int[] badTimes) {
        int min = badTimes[0];
        int max = 0;
        for (int i = 0; i < goodTimes.length; i++) {
            if (max < goodTimes[i]) {
                max = goodTimes[i];
            }
        }
        for (int i = 1; i < badTimes.length; i++) {
            if (min > badTimes[i]) {
                min = badTimes[i];
            }
        }
        if (min > max) {
            return min - 1;
        } else {
            return -1;
        }
    }
}