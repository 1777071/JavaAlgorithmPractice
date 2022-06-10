public class LargestSubsequence {

    public String getLargest(String s) {
        String ret = "";
        int min;

        for (int i = 0; i < s.length(); i++) {
            min = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) > s.charAt(min)) {
                    min = j;
                }
            }

            ret += s.charAt(min);
            i = min;
        }

        return ret;
    }

}