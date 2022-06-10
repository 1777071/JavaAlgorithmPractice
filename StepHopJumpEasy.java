public class StepHopJumpEasy {
    public static void main(String[] args) {
        String a = "-*--**---**----**-----";
        StepHopJumpEasy shp = new StepHopJumpEasy();
        String result = shp.solve(a);
        System.out.println(result);
    }

    public String solve(String a) {
        String res = "";
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == '*') {
                if (i + 1 == a.length()) {
                    res += 'H';
                } else {
                    if (a.charAt(i + 1) == '*') {
                        if (i + 2 == a.length()) {
                            res += 'J';
                        } else {
                            if (a.charAt(i + 2) == '*') {
                                return "";
                            }
                            res += "J";
                            i = i + 2;
                        }
                    } else {
                        res += "H";
                        i = i + 1;
                    }
                }
            } else {
                res += "S";
            }
        }
        return res;
    }
}