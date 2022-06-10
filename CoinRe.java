public class CoinRe {
    public static void main(String[] args) {
        int a = 3;
        int[] b = {2, 2};
        CoinRe cr = new CoinRe();
        double result = cr.expectedHeads(a, b);
        System.out.println(result);
    }

    public double expectedHeads(int N, int[] a) {
        double numHeads = N;
        double numTails = 0;
        for (int i = 0; i < a.length; i++) {
            double heads = ((double) a[i] / N) * numHeads;
            double tails = ((double) a[i] / N) * numTails;
            numHeads = numHeads - heads + tails;
            numTails = numTails - tails + heads;
        }
        return numHeads;
    }
}
