public class UnderscoreJustification {
    public String justifyLine(String[] words, int width) {
        int n = words.length;
        int sumlen = 0;
        for (int i = 0; i < n; i++)
            sumlen += words[i].length();
        sumlen = width - sumlen;
        int len1 = sumlen / (n - 1);
        int count2 = sumlen % (n - 1);
        int count1 = n - 1 - count2;
        String str1 = "";
        for (int i = 0; i < len1; i++)
            str1 += "_";
        String str2 = str1 + "_";

        String res = words[0];
        for (int i = 1; i < n; i++) {
            char c = words[i].charAt(0);
            if (Character.isUpperCase(c)) {
                if (count1 > 0) {
                    res += str1;
                    count1--;
                } else {
                    res += str2;
                    count2--;
                }
            } else {
                if (count2 > 0) {
                    res += str2;
                    count2--;
                } else {
                    res += str1;
                    count1--;
                }
            }
            res += words[i];
        }
        return res;
    }


}