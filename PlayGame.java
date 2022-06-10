import java.util.Arrays;

public class PlayGame {
    public int saveCreatures(int[] you, int[] comp) {
        int i, j, save = 0;
        Arrays.sort(you);
        Arrays.sort(comp);

        j = you.length - 1;
        for (i = comp.length - 1; (i >= 0) && (j >= 0); i--) {
            if (you[j] > comp[i]) {
                save += you[j--];
            }
        }

        return save;
    }
};