public class CreateGroups {
    public int minChanges(int[] groups, int minSize, int maxSize) {
        int sum = 0;
        int over = 0;
        int less = 0;
        for (int i = 0; i < groups.length; i++) {
            over += Math.max(0, groups[i] - maxSize);
            less += Math.max(0, minSize - groups[i]);
            sum += groups[i];
        }

        if (sum < minSize * groups.length || maxSize * groups.length < sum) {
            return -1;
        }

        return Math.max(over, less);
    }

}