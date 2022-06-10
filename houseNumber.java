public class houseNumber {
    public static void main(String[] args) {
        int start = 160;
        int number = 47;
        houseNumber hn = new houseNumber();
        int[] result = hn.prepareDigits(start, number);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public int[] prepareDigits(int firstHouse, int numberOfHouses) {
        int[] result = new int[10];
        int start = firstHouse;
        int number = numberOfHouses;
        String middle = String.valueOf(start);
        for (int i = 0; i < number - 1; i++) {
            start += 2;
            middle += String.valueOf(start);
        }
        System.out.println(middle + "================");
        for (int i = 0; i < middle.length(); i++) {
            switch (middle.charAt(i)) {
                case '0':
                    result[0]++;
                    break;
                case '1':
                    result[1]++;
                    break;
                case '2':
                    result[2]++;
                    break;
                case '3':
                    result[3]++;
                    break;
                case '4':
                    result[4]++;
                    break;
                case '5':
                    result[5]++;
                    break;
                case '6':
                    result[6]++;
                    break;
                case '7':
                    result[7]++;
                    break;
                case '8':
                    result[8]++;
                    break;
                case '9':
                    result[9]++;
                    break;
            }
        }
        return result;
    }
}