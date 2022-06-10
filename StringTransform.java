import java.util.ArrayList;

public class StringTransform {
    ArrayList<String> sites = new ArrayList<String>();

    public static void main(String[] args) {
        String a = "rdmcxnnbbe";
        String b = "rdrrxrnxbe";
        StringTransform sts = new StringTransform();
        String result = sts.isPossible(a, b);
        System.out.println(result);
    }

    public String isPossible(String a, String b) {
        sites.add(String.valueOf(a.charAt(0)));
        for (int i = 1; i < b.length(); i++) {
            if (b.charAt(i) == a.charAt(i)) {
                sites.add(String.valueOf(a.charAt(i)));
                continue;
            } else {
                boolean have = false;
                for (int j = 0; j < sites.size(); j++) {
                    char mid = sites.get(j).charAt(0);
                    if (b.charAt(i) == mid) {
                        have = true;
                        break;
                    }
                }
                if (!have) {
                    return "impossible";
                }
            }
        }
        return "possible";
    }
}
/*public class StringTransform{
  public String isPossible(String s, String t){
    if(s==null || s.length() ==0){ return "Possible";}
    boolean[] charE = new boolean[256];
    for(int i = 0; i<s.length(); i++){
      charE[(int)s.charAt(i)] = true;
      if(!charE[(int)t.charAt(i)]){
        return "Impossible";
      }
    }
    return "Possible";
  }
}*/