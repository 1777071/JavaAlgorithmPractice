public class PPuzzle {
    public char[][] maze;
    public int ylen;
    public int xlen;
    public int res = 0;

    public static void main(String[] args) {
        String[] a = {"ELLLLL+",
                "++++++L",
                "L+++++L",
                "L+++++L",
                "L+++++L",
                "L+++++L",
                "+LLLLLL"};
        PPuzzle pz = new PPuzzle();
        int result = pz.longest(a);
        System.out.println(result);
    }

    public int longest(String[] pipes) {
        ylen = pipes.length;
        xlen = pipes[0].length();

        maze = new char[ylen][];
        for (int y = 0; y < ylen; y++) {
            maze[y] = pipes[y].toCharArray();
        }

        for (int y = 0; y < ylen; y++) {
            for (int x = 0; x < xlen; x++) {
                if ('N' == maze[y][x]) {
                    trace(x, y - 1, 'S', 0);
                } else if ('S' == maze[y][x]) {
                    trace(x, y + 1, 'N', 0);
                } else if ('W' == maze[y][x]) {
                    trace(x - 1, y, 'E', 0);
                } else if ('E' == maze[y][x]) {
                    trace(x + 1, y, 'W', 0);
                }
            }
        }

        return res;
    }

    public void bidResult(int bid) {
        if (bid > res)
            res = bid;
    }

    public void trace(int x, int y, char entry, int curres) {
        if ((x < 0) || (y < 0) || (x >= xlen) || (y >= ylen)) {
            bidResult(curres);
            return;
        }
        if ('S' == entry) {
            if ('+' == maze[y][x]) {
                trace(x, y - 1, 'S', curres + 1);
            }
            if ('-' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x, y - 1, 'S', curres + 1);
                maze[y][x] = '-';
            }
            if ('L' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x - 1, y, 'E', curres + 1);
                trace(x + 1, y, 'W', curres + 1);
                maze[y][x] = 'L';
            }
            bidResult(curres);
        }

        // ===========]
        if ('N' == entry) {
            if ('+' == maze[y][x]) {
                trace(x, y + 1, 'N', curres + 1);
            }
            if ('-' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x, y + 1, 'N', curres + 1);
                maze[y][x] = '-';
            }
            if ('L' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x - 1, y, 'E', curres + 1);
                trace(x + 1, y, 'W', curres + 1);
                maze[y][x] = 'L';
            }
            bidResult(curres);
        }

        // ===========]
        if ('W' == entry) {
            if ('+' == maze[y][x]) {
                trace(x + 1, y, 'W', curres + 1);
            }
            if ('-' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x + 1, y, 'W', curres + 1);
                maze[y][x] = '-';
            }
            if ('L' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x, y - 1, 'S', curres + 1);
                trace(x, y + 1, 'N', curres + 1);
                maze[y][x] = 'L';
            }
            bidResult(curres);
        }

        // ===========]
        if ('E' == entry) {
            if ('+' == maze[y][x]) {
                trace(x - 1, y, 'E', curres + 1);
            }
            if ('-' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x - 1, y, 'E', curres + 1);
                maze[y][x] = '-';
            }
            if ('L' == maze[y][x]) {
                maze[y][x] = '#';
                trace(x, y - 1, 'S', curres + 1);
                trace(x, y + 1, 'N', curres + 1);
                maze[y][x] = 'L';
            }
            bidResult(curres);
        }

    }

}