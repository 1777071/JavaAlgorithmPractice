public class LongMansionDiv2 {
    public long minimalTime(int M, int[] t) {
        var ret = 0L;
        var n = t.Length;

        for (int i = 0; i < n; i++) {
            ret += (long) t[i];
        }

        ret += (long) (M - 1) * (long) t.Min();

        return ret;
    }

}