public class PickC {
    public static void main(String[] args) {
        String start = "AA";
        PickC pc = new PickC();

        double res = pc.equalProbability(start);
        System.out.println(res);
    }

    public double equalProbability(String cards) {
        int fz = 0;
        int fm = (cards.length()) * ((cards.length()) - 1) / 2;

        for (int i = 0; i < cards.length(); i++) {
            for (int j = i + 1; j < cards.length(); j++) {
                if (cards.charAt(j) == cards.charAt(i)) {

                    fz++;
                }
            }
        }
        return (double) (fz) / (double) (fm);
    }
}