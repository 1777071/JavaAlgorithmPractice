public class MinCostPalindrome {

    public static int getMinimum(String s, int oCost, int xCost) {
        int cost = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == '?' || s.charAt(s.length() - i - 1) == '?') {
                if (s.charAt(i) == '?' && s.charAt(s.length() - i - 1) != '?') {
                    cost += (s.charAt(s.length() - i - 1) == 'o') ? oCost : xCost;
                } else if (s.charAt(i) != '?' && s.charAt(s.length() - i - 1) == '?') {
                    cost += (s.charAt(i) == 'o') ? oCost : xCost;
                } else {
                    cost += ((oCost < xCost) ? oCost : xCost) * 2;
                }


            } else if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return -1;
        }
        return cost;
    }

}