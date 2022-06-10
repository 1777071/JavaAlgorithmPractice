public class crossR {
    public static void main(String[] args) {
        int stone = 123456;
        int mod = 1000000007;
        int maxt = 2;
        crossR cr = new crossR();
        long result = cr.minLength(stone, mod, maxt);
        System.out.print(result);
    }

    public long minLength(int N, int M, int J) {
        long[] middle = new long[N];
        long[] middle1 = new long[J];
        long result = 0;
        int index = 0;

        long max = 0;
        boolean same = true;
        for (int i = 0; i < N; i++) {
            middle[i] = 1 + (i * i) % M;
        }
        long start = middle[0];
        for (int i = 0; i < N; i++) {
            max += middle[i];
        }
        double time = (double) max / (double) J;
        for (int i = 0; i < middle.length; i++) {
            if (start != middle[i]) {
                same = false;
                break;
            }
        }
        if (same == true) {
            if (time > (double) (max / J)) {
                return (max / J) + 1;
            } else {
                return max / J;
            }
        } else {
            if (N == J) {
                return middle[N - 1];
            } else {
                int indexN = 0;
                long fin = 0;
                for (int i = 0; i < N - 1; i++) {
                    result += middle[i];
                    if ((double) result > time) {
                        double mid = (double) result - middle[i] - time;
                        if (mid < 0) {
                            mid = mid * (-1.0);
                        }
                        if (((double) result - time) > mid) {
                            middle1[indexN] = result - middle[i];
                            indexN++;
                            result = middle[i];
                        } else {
                            middle1[indexN] = result;
                            indexN++;
                            result = middle[i + 1];
                            i++;
                            fin = middle[i + 1];
                            continue;
                        }
                    }
                }
                long finr = middle1[0];
                for (int i = 0; i < middle1.length; i++) {
                    if (middle1[i] == 0) {
                        middle1[i] = fin;
                    }
                }
                for (int i = 1; i < middle1.length - 1; i++) {
                    if (finr < middle1[i]) {
                        finr = middle1[i];
                    }
                }
                return finr;
            }
        }
    }
}