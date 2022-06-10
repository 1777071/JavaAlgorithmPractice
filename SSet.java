public class SSet {
    public static void main(String[] args) {
        int[] a = {11, 11, 49, 7, 11, 11, 7, 7, 11, 49, 11};
        SSet st = new SSet();
        int result = st.getMinimalSize(a);
        System.out.println(result);
    }

    public void Bubble(int[] a, int b) {
        int[] c = new int[b];
        for (int i = 0; i < b; i++) {
            for (int j = 1; j < b - i; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }

        }
    }

    public int getMinimalSize(int[] a) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        Bubble(a, a.length);
        int number = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != c[i]) {
                number++;
            }
        }
        return number;
    }
}