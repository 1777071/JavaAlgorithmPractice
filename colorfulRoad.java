public class colorfulRoad {
    public static void main(String[] args) {
        String a = "RGGGB";
        colorfulRoad cr = new colorfulRoad();
        int result = cr.getMin(a);
        System.out.println(result);
    }

    public int getMin(String a) {
        int[] get = new int[a.length()];
        for (int i = 0; i < get.length; i++) {
            get[i] = 1000000;
        }
        get[a.length() - 1] = 0;
        for (int i = a.length() - 1; i >= 1; i--) {
            char prev = thePrev(a.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if (a.charAt(j) == prev) {
                    int curCost = get[j];
                    int newCost = get[i] + (i - j) * (i - j);

                    if (curCost > newCost) {
                        get[j] = newCost;
                    }
                }
            }
        }
        if (get[0] == 1000000) {
            return -1;
        } else {
            return get[0];
        }

    }

    public char thePrev(char a) {
        if (a == 'R') {
            return 'B';
        }
        if (a == 'B') {
            return 'G';
        }
        if (a == 'G') {
            return 'R';
        }
        return 'p';
    }
}