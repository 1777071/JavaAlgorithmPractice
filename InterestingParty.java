import java.util.*;

public class InterestingParty {
    public int bestInvitation(String[] first, String[] second) {

        TreeSet<String> set = new TreeSet<String>();
        int res = 0;

        for (int i = 0; i < second.length; i++) {
            set.add(first[i]);
            set.add(second[i]);
        }

        for (String topic : set) {
            int foo = 0;
            for (int i = 0; i < second.length; i++) {
                if (topic.equals(first[i]) || topic.equals(second[i])) foo++;
            }
            if (foo > res) res = foo;
        }


        return res;

    }


}