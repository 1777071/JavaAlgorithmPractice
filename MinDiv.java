public class MinDiv {
    public static void main(String[] args) {
        int fir = 7;
        int sec = 20;
        int third = 5;
        MinDiv md = new MinDiv();
        int[] result = md.findTriple(fir, sec, third);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] findTriple(int x0, int x1, int x2) {
        int[] result = new int[3];
        int[] middle = {0, 0, 0};
        int[] finalR = new int[3];
        result[0] = x0;
        result[1] = x1;
        result[2] = x2;
        double min = 999.9;
        int index = 0;
        double mid = 9999.9;
        for (int i = 0; i < 3; i++) {
            middle[0] = result[i];
            switch (i) {
                case 0:
                    middle[1] = result[1];
                    middle[2] = result[2];
                    mid = Cal(middle);
                    System.out.println("====" + mid);
                    if (min > mid) {
                        min = mid;
                        for (int j = 0; j < 3; j++) {
                            finalR[j] = middle[j];
                        }
                    }
                    middle[1] = result[2];
                    middle[2] = result[1];
                    mid = Cal(middle);

                    if (min > mid) {
                        min = mid;
                        for (int j = 0; j < 3; j++) {
                            finalR[j] = middle[j];
                        }
                    }
                    break;
                case 1:
                    middle[1] = result[0];
                    middle[2] = result[2];
                    mid = Cal(middle);
                    if (min > mid) {
                        min = mid;
                        for (int j = 0; j < 3; j++) {
                            finalR[j] = middle[j];
                        }
                    }
                    middle[1] = result[2];
                    middle[2] = result[0];
                    mid = Cal(middle);
                    if (min > mid) {
                        min = mid;
                        for (int j = 0; j < 3; j++) {
                            finalR[j] = middle[j];
                        }
                    }
                    break;
                case 2:
                    middle[1] = result[0];
                    middle[2] = result[1];
                    mid = Cal(middle);

                    if (min > mid) {
                        min = mid;
                        for (int j = 0; j < 3; j++) {
                            finalR[j] = middle[j];
                        }
                    }
                    middle[1] = result[1];
                    middle[2] = result[0];
                    mid = Cal(middle);
                    System.out.println("====" + mid);
                    if (min > mid) {
                        min = mid;
                        for (int j = 0; j < 3; j++) {
                            finalR[j] = middle[j];
                        }
                    }
                    break;
            }
        }

        int[] ffr = new int[3];
        int index1 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (finalR[i] == result[j]) {
                    ffr[index] = j;
                    index++;
                }
            }
        }

        return ffr;
    }

    public double Cal(int[] middle) {
        double fir = (double) (middle[0]) / (double) (middle[1]);
        double sec = (fir - (double) (middle[2]));
        if (sec < 0) {
            sec = sec * (-1);
        }
        return sec;
    }
}