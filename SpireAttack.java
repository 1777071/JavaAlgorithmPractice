public class SpireAttack {
    int index = 0;

    public static void main(String[] args) {
        int a = 3;
        int[] b = {1, 2, 3};
        int[] c = {1, 4, 9};
        SpireAttack sa = new SpireAttack();
        int result = sa.dealMostDamage(a, b, c);
        System.out.println(result);
    }

    public int dealMostDamage(int a, int[] b, int[] c) {
        int nas = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] > a) {
                continue;
            }
            if (c[i] > nas) {
                nas = c[i];
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] + b[j] > a) {
                    continue;
                }
                if (c[i] + c[j] > nas) {
                    nas = c[i] + c[j];
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                for (int k = j + 1; k < b.length; k++) {
                    if (b[i] + b[j] + b[k] > a) {
                        continue;
                    }
                    if (c[i] + c[j] + c[k] > nas) {
                        nas = c[i] + c[j] + c[k];
                    }
                }
            }
        }
        return nas;
    }
}