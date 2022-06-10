public class GogoXBallsAndBinsEasy {

    public int solve(int[] t) {
        int ans = 0;
        int n = t.length;
        for (int i = 0; i < (n / 2); i++) {
            ans += t[n - i - 1] - t[i];
        }

        return ans;
    }

}