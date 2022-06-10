public class TrafficCongestionDivTwo {

    public long theMinCars(int treeHeight) {
        boolean t = (treeHeight & 1) == 0;
        long r = 0;
        for (int i = 0; i < treeHeight; i++) {
            r <<= 1;
            if ((i & 1) == 0) {
                r++;
            }
        }
        if (t) r++;
        return r;
    }

