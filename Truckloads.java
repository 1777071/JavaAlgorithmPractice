public class Truckloads {

    public static void main(String[] args) {
        int a = 1024;
        int b = 5;
        Truckloads tr = new Truckloads();
        int result = tr.numTrucks(a, b);
        System.out.println(result);
    }

    public int numTrucks(int a, int b) {
        if (a <= b) {
            return 1;
        } else {

            if (a % 2 == 1) {
                int mid = a / 2;
                int mid1 = mid + 1;
                int res = numTrucks(mid, b);
                int res1 = numTrucks(mid1, b);
                return res + res1;
            } else {
                int mid = a / 2;
                int res = numTrucks(mid, b);
                return 2 * res;
            }
        }
    }
}