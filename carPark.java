public class carPark {
    public static void main(String[] args) {
        int carNum = 4;
        int claNum = 1;
        carPark caP = new carPark();
        int result = caP.count(carNum, claNum);
        System.out.println(result);
    }

    public int count(int carNum, int claNum) {
        long result1 = 0;
        if (claNum == 0) {
            result1 = 1;
            int middle = carNum;
            for (int i = 0; i < middle; i++) {
                result1 = result1 * carNum;
                carNum--;
            }
            return (int) (result1 % 1000000007);
        } else {
            int[] count = new int[carNum];
            int[] middle1 = new int[carNum];

        }
        return 10;
    }

    public int clash(int[] clash) {
        int middle = 0;
        boolean[] haveP = new boolean[clash.length];
        for (int i = 0; i < clash.length; i++) {
            for (int j = 1; j < clash.length; j++) {
                if ()
            }
        }
        return middle;
    }
}