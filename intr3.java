public class intr3 {
    public static void main(String[] args) {
        int[] middle = {9};
        intr3 intr = new intr3();
        int result = intr.count(middle);
        System.out.println(result);
    }

    public int count(int[] array) {
        int count = 1;
        int middle = 0;
        int length = 0;
        int result1 = 0;
        boolean same = false;

        String[] large = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            large[i] = String.valueOf(array[i]);
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < large[i].length(); j++) {
                for (int k = 0; k < large[i + 1].length(); k++) {
                    if (large[i].charAt(j) != large[i + 1].charAt(k)) {
                        same = true;
                    } else {
                        if (large[i].charAt(j) == large[i + 1].charAt(k)) {
                            same = false;
                            break;
                        }
                    }
                }
                if (same == true) {
                    break;
                }
            }
            if (same == false) {
                count++;
            }
            if (same == true) {
                same = false;
                if (count > 1) {
                    int time = count;
                    for (int m = 1; m < time; m++) {
                        result1 += (count - 1);
                        count--;
                    }
                }
                count = 1;
            }

        }
        if (same == false && count > 1) {
            if (count > 1) {
                int time = count;
                for (int m = 1; m < time; m++) {
                    result1 += (count - 1);
                    count--;
                }
            }
            count = 1;

        }
        return result1;
    }
}