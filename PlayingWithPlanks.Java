public class PlayingWithPlanks {
    public static void main(String[] args) {
        int a = 9;
        int b = 4;
        PlayingWithPlanks pwp = new PlayingWithPlanks();
        String result = pwpw.canItBeDone(a, b);
        System.out.println(result);
    }

    public String canItBeDone(int a, int b) {
        long res = ((long) 1 + b) * b / 2;
        if (res <= a) {
            return "possible";
        } else {
            return "impossible";
        }
    }
}