public class linePoint {
    public static void main(String args[]) {
        int[][] middle = {{2, 3}, {3, 3}, {-5, 3}};
        linePoint LP = new linePoint();
        int res = LP.maxPoint(middle);
        System.out.println(res);

    }

    public int maxPoint(int[][] middle) {
        int maxNum = 0;
        for (int i = 0; i < middle.length - 1; i++) {
            int a = 1;
            double k = (middle[i + 1][1] - middle[i][1]) / (middle[i + 1][0] - middle[i][0]);
            double b = middle[i][1] - k * middle[i][0];
            for (int j = i + 1; j < middle.length; j++) {
                if (middle[j][1] == k * middle[j][0] + b) {
                    a++;
                }
            }
            if (maxNum < a) {
                maxNum = a;
            } else {
                a = 0;
            }
        }
        return maxNum;
    }
}