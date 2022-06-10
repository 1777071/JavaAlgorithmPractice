public class Symmetry {
    public static void main(String[] args) {
        String[] a = {"....",
                ".##.",
                "#####"};
        Symmetry st = new Symmetry();
        String result = st.detect(a);
        System.out.println(result);
    }

    public String detect(String[] board) {
        int indexV = 0;
        int indexH = 0;
        if (board.length == 1) {
            if (board[0].length() == 1) {
                return "both";
            } else {
                if (checkV(board[0])) {
                    return "Vertically symmetric";
                } else {
                    return "Neither";
                }
            }

        } else {
            boolean[] allV = new boolean[board.length];
            boolean allVa = true;
            boolean allHa = false;
            String mid = "";
            String mid1 = "";
            for (int i = 0; i < board.length; i++) {
                allV[i] = checkV(board[i]);
            }
            for (int i = 0; i < board.length; i++) {
                if (!allV[i]) {
                    allVa = false;
                }
            }
            if (board.length % 2 == 1) {

                indexH = (board.length - 1) / 2;
                for (int i = 0; i < indexH; i++) {
                    mid += board[i];
                }

                for (int i = board.length - 1; i > indexH; i--) {
                    mid1 += board[i];
                }

                if (mid.equals(mid1)) {
                    allHa = true;
                }
            } else {
                indexH = (board.length) / 2;
                indexH = (board.length - 1) / 2;
                for (int i = 0; i < indexH; i++) {
                    mid += board[i];
                }
                for (int i = board.length - 1; i > indexH - 1; i--) {
                    mid1 += board[i];
                }
                mid1 = new StringBuffer(mid1).reverse().toString();
                if (mid.equals(mid1)) {
                    allHa = true;
                }
            }
            if (allVa && allHa) {
                return "both";
            }
            if (allVa && !(allHa)) {
                return "Vertically symmetric";
            }
            if (!(allVa) && allHa) {
                return "Horizontally symmetric";
            }

        }
        return "Neither";
    }

    public boolean checkV(String a) {
        int indexV = 0;

        if (a.length() == 1) {
            return true;
        }
        if (a.length() % 2 == 1) {
            indexV = (a.length() - 1) / 2;
            String mid = "";
            String mid1 = "";
            for (int i = 0; i < indexV; i++) {
                mid += a.charAt(i);
            }
            for (int i = indexV + 1; i < a.length(); i++) {
                mid1 += a.charAt(i);
            }
            mid1 = new StringBuffer(mid1).reverse().toString();
            if (mid.equals(mid1)) {
                return true;
            } else {
                return false;
            }
        } else {
            indexV = a.length() / 2;
            String mid = "";
            String mid1 = "";
            for (int i = 0; i < indexV; i++) {
                mid += a.charAt(i);
            }
            for (int i = indexV; i < a.length(); i++) {
                mid1 += a.charAt(i);
            }
            mid1 = new StringBuffer(mid1).reverse().toString();
            if (mid.equals(mid1)) {
                return true;
            } else {
                return false;
            }
        }
    }
}