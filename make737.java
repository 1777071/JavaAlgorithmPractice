public class make737 {
    public static void main(String[] args) {
        String start = "773377";
        make737 m7 = new make737();
        int result = m7.count(start);
        System.out.println(result);
    }

    public int count(String s) {
        int result = 0;
        int index = 0;
        int a = s.length() - 1;
        int index1 = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == '7') {
                index = i + 1;
                for (int j = index; j < a; j++) {
                    if (s.charAt(j) == '3') {
                        index1 = j + 1;
                        for (int k = index1; k < s.length(); k++) {
                            if (s.charAt(k) == '7') {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
