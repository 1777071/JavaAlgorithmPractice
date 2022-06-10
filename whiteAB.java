public class whiteAB {
    public static void main(String[] args) {
        String start = "W-B--B---BB-";
        whiteAB wa = new whiteAB();
        String result = wa.play(start);
        System.out.println(result);
    }

    public String play(String board) {
        String result = "";
        int index = 0;
        boolean jump = false;
        for (int i = 1; i < board.length(); i++) {
            switch (board.charAt(i)) {
                case '-':
                    index = i;
                    break;
                case 'B':
                    if (board.charAt(i + 1) == 'B') {
                        index = i - 1;
                        jump = true;
                    }
                    break;
            }
            if (jump) {
                break;
            }
        }

        if (index != 0) {
            StringBuilder sb = new StringBuilder(board);
            sb.setCharAt(0, '-');
            sb.setCharAt(index, 'w');
            board = sb.toString();
        }

        result = board;
        return result;
    }

}