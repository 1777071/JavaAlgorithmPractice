public class ColorfulTilesEasy {
    int ret;

    public int theMin(String room) {
        char[] c = room.toCharArray();

        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1]) {
                c[i] = 'C';
                ret++;
            }
        }
        return ret;
    }


}