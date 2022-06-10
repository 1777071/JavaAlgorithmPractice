public class DecimalCoins {
    public static void main(String[] args) {
        int[] a = {103, 1, 89, 0, 499, 3, 7};
        DecimalCoins dc = new DecimalCoins();
        int result = dc.pay(a);
        System.out.println(result);
    }

    public int pay(int[] coins) {
        int index = 0;
        int currentV = 0;
        boolean all = false;

        for (int i = 0; i < coins.length - 1; i++) {
            index = i;
            currentV += Math.pow(10, i) * coins[i];
            if (currentV + 1 >= Math.pow(10, i + 1)) {

                if (index == 5) {
                    all = true;
                }
                continue;
            } else {
                return currentV + 1;
            }
        }

        if (all) {
            int MaxV = 0;
            for (int i = 0; i < coins.length; i++) {
                MaxV += Math.pow(10, i) * coins[i];
            }
            MaxV++;
            return MaxV;
        }

        return 956956956;
    }
}
