public class ColorfulCoinsEasy {
    public String isPossible(int[] values) {
        int[] edited = new int[values.length - 1];
        if (values.length == 1)
            return "Possible";
        for (int i = 0; i < values.length - 1; i++) {
            edited[i] = (values[i + 1] / values[i]) - 1;
        }
        Arrays.sort(edited);
        for (int i = 0; i < edited.length; i++)
            if (edited[i] <= i)
                return "Impossible";
        return "Possible";
    }


}