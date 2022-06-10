public class intr2 {
    public static void main(String[] args) {
        String middle = "|-||-|-";
        int result = 0;
        intr2 intr = new intr2();
        result = intr.getLength(middle);
        System.out.println(result);
    }

    public int getLength(String s) {
        int max = 0;
        int count = 1;
        char sta = s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            if (sta != s.charAt(i + 1)) {
                count++;
                sta = s.charAt(i + 1);
            } else {
                count = 1;
            }
            if (count > max) {
                max = count;
            }

        }
        return max;
    }
}