import java.util.*;

public class GroceryBagger {
    public int minimumBags(int strength, String[] itemType) {
        int res = 0;
        Set types = new HashSet();

        for (int i = 0; i < itemType.length; i++) {
            String s = itemType[i];
            if (!types.contains(s)) {
                types.add(s);
                int counter = 0;
                for (int j = 0; j < itemType.length; j++) {
                    if (itemType[j].equals(s)) {
                        counter++;
                    }
                }

                res += (counter / strength);
                if (counter % strength > 0) {
                    res++;
                }
            }
        }

        return res;

    }
}