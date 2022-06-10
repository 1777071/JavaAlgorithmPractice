public class NumericalSequence {
    public int makePalindrome(int[] sequence) {
        int min = 0;

        int lo = 0, hi = sequence.length - 1;

        while (lo < hi) {
            if (sequence[lo] == sequence[hi]) {
                lo++;
                hi--;
            } else if (sequence[lo] < sequence[hi]) {
                sequence[lo + 1] += sequence[lo];
                lo++;
                min++;
            } else {
                sequence[hi - 1] += sequence[hi];
                min++;
                hi--;
            }
        }

        return min;
    }
}