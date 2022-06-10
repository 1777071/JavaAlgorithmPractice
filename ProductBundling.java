import java.util.*;

public class ProductBundling {
    public int howManyBundles(String[] data) {
        String[] s = new String[data[0].length()];
        Arrays.fill(s, "");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < data.length; j++) s[i] += data[j].charAt(i);
        }
        TreeSet<String> t = new TreeSet<String>();
        for (int i = 0; i < s.length; i++) t.add(s[i]);
        return t.size();
    }
}