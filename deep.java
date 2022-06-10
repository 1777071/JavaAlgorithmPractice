public class deep {
    public static void main(String args[]) {
        int[] middle = {1, 5, 3, 4, 2};
        int deepth = 0;
        deep Deep = new deep();
        int res = Deep.run(middle, deepth);
        System.out.println(res);
    }

    public int run(int[] middle, int deepth) {
        int midNum = 0;
        for (int i = 0; i < middle.length; i++) {
            for (int j = 1; j < middle.length - 1; j++) {
                if (middle[j - 1] > middle[j]) {
                    midNum = middle[j - 1];
                    middle[j - 1] = middle[j];
                    middle[j] = midNum;
                }
            }
        }


        if (middle.length == 1) {

            return deepth;
        } else {
            int newlength = middle.length % 2;
            deepth++;
            if (newlength == 0) {
                int[] middle1 = new int[middle.length / 2];
                for (int i = 0; i < middle1.length; i++) {
                    middle1[i] = middle[i];
                }
                return run(middle1, deepth);
            } else {
                int[] middle1 = new int[(middle.length - 1) / 2];
                for (int i = 0; i < middle1.length; i++) {
                    middle1[i] = middle[i];
                }
                return run(middle1, deepth);
            }

        }
    }
}