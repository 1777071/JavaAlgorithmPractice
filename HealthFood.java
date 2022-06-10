import java.util.ArrayList;

public class HealthFood {
    public static void main(String[] args) {
        int[] a = {18, 86, 76, 0, 34, 30, 95, 12, 21};
        int[] b = {26, 56, 3, 45, 88, 0, 10, 27, 53};
        int[] c = {93, 96, 13, 95, 98, 18, 59, 49, 86};
        String[] d = {"f", "Pt", "PT", "fT", "Cp", "C", "t", "",
                "cCp", "ttp", "PCFt", "P", "pCt", "cP", "Pc"};
        HealthFood hf = new HealthFood();
        int[] res = hf.selectMeals(a, b, c, d);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
        int[] mid = new int[dietPlans.length];
        for (int i = 0; i < dietPlans.length; i++) {

            mid[i] = GetN(protein, carbs, fat, dietPlans[i]);
        }
        return mid;
    }

    public int GetN(int[] protein, int[] carbs, int[] fat, String dietPlans) {
        if (dietPlans.length() == 0) {
            return 0;
        }
        if (dietPlans.length() == 1) {
            int index = 0;
            switch (dietPlans) {
                case "P":
                    int max = 0;
                    for (int i = 0; i < protein.length; i++) {
                        if (protein[i] > max) {
                            max = protein[i];
                            index = i;
                        }
                    }
                    break;
                case "p":
                    int min = 0;
                    for (int i = 0; i < protein.length; i++) {
                        if (protein[i] > 0) {
                            min = protein[i];
                            break;
                        }
                    }
                    for (int i = 0; i < protein.length; i++) {
                        if (protein[i] < min && protein[i] >= 0) {
                            min = protein[i];
                            index = i;
                        }
                    }
                    break;
                case "F":
                    int max1 = 0;
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[i] > max1) {
                            max1 = fat[i];
                            index = i;
                        }
                    }
                    break;
                case "f":
                    int min1 = 0;
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[i] > 0) {
                            min1 = fat[i];
                            break;
                        }
                    }
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[i] < min1 && fat[i] >= 0) {
                            min1 = fat[i];
                            index = i;
                        }
                    }
                    break;
                case "C":
                    int max2 = 0;
                    for (int i = 0; i < carbs.length; i++) {
                        if (carbs[i] > max2) {
                            max2 = carbs[i];
                            index = i;
                        }
                    }
                    break;
                case "c":
                    int min2 = 0;
                    for (int i = 0; i < carbs.length; i++) {
                        if (carbs[i] > 0) {
                            min2 = carbs[i];
                            break;
                        }
                    }
                    for (int i = 0; i < carbs.length; i++) {
                        if (carbs[i] < min2 && carbs[i] >= 0) {
                            min2 = carbs[i];
                            index = i;
                        }
                    }
                    break;
                case "T":
                    int index1 = 0;
                    int[] cal = new int[fat.length];
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[index1] < 0 || protein[index1] < 0 || carbs[index1] < 0) {
                            cal[index1] = 0;
                            index1++;
                            continue;
                        }
                        cal[index1] = 9 * fat[index1] + 5 * (protein[index1] + carbs[index1]);
                        index1++;
                    }
                    int max3 = 0;
                    for (int i = 0; i < cal.length; i++) {
                        if (cal[i] > max3) {
                            max3 = carbs[i];
                            index = i;
                        }
                    }
                    break;
                case "t":
                    int index12 = 0;
                    int[] cal1 = new int[fat.length];
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[index12] < 0 || protein[index12] < 0 || carbs[index12] < 0) {
                            cal1[index12] = 0;
                            index12++;
                            continue;
                        }
                        cal1[index12] = 9 * fat[index12] + 5 * (protein[index12] + carbs[index12]);
                        index12++;
                    }
                    int min3 = 0;
                    for (int i = 0; i < cal1.length; i++) {
                        if (cal1[i] != 0) {
                            min3 = cal1[i];
                            break;
                        }
                    }
                    for (int i = 0; i < cal1.length; i++) {
                        if (cal1[i] < min3 && cal1[i] > 0) {
                            min3 = cal1[i];
                            index = i;
                        }
                    }
                    break;
            }
            return index;
        } else {
            int index = 0;
            int[] a = new int[protein.length];
            int[] b = new int[carbs.length];
            int[] c = new int[fat.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = -1;
                b[i] = -1;
                c[i] = -1;
            }
            boolean rec = false;
            String mid = "";

            mid += dietPlans.charAt(0);

            switch (mid) {
                case "P":
                    int max4 = 0;

                    for (int i = 0; i < protein.length; i++) {
                        if (protein[i] > max4) {
                            max4 = protein[i];
                            index = i;
                        }
                    }
                    for (int i = 0; i < protein.length; i++) {
                        if (max4 == protein[i]) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
                case "p":
                    int min4 = 0;
                    for (int i = 0; i < protein.length; i++) {
                        if (protein[i] != 0) {
                            min4 = protein[i];
                            break;
                        }
                    }
                    for (int i = 0; i < protein.length; i++) {
                        if (protein[i] < min4 && protein[i] >= 0) {
                            min4 = protein[i];
                            index = i;
                        }
                    }
                    for (int i = 0; i < protein.length; i++) {
                        if (min4 == protein[i]) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
                case "F":
                    int max5 = 0;
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[i] > max5) {
                            max5 = fat[i];
                            index = i;
                        }
                    }
                    for (int i = 0; i < fat.length; i++) {
                        if (max5 == fat[i]) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
                case "f":
                    int min5 = 0;
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[i] > 0) {
                            min5 = fat[i];
                            break;
                        }
                    }
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[i] < min5 && fat[i] >= 0) {
                            min5 = fat[i];
                            index = i;
                        }
                    }
                    for (int i = 0; i < fat.length; i++) {
                        if (min5 == fat[i]) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
                case "C":
                    int max6 = 0;
                    for (int i = 0; i < carbs.length; i++) {
                        if (carbs[i] > max6) {
                            max6 = carbs[i];
                            index = i;
                        }
                    }
                    for (int i = 0; i < carbs.length; i++) {
                        if (max6 == carbs[i]) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
                case "c":
                    int min6 = 0;
                    for (int i = 0; i < carbs.length; i++) {
                        if (carbs[i] > 0) {
                            min6 = carbs[i];
                            break;
                        }
                    }
                    for (int i = 0; i < carbs.length; i++) {
                        if (carbs[i] < min6 && carbs[i] >= 0) {
                            min6 = carbs[i];
                            index = i;
                        }
                    }
                    for (int i = 0; i < carbs.length; i++) {
                        if (min6 == carbs[i]) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
                case "T":
                    int index13 = 0;
                    int[] cal3 = new int[fat.length];
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[index13] < 0 || protein[index13] < 0 || carbs[index13] < 0) {
                            cal3[index13] = 0;
                            index13++;
                            continue;
                        }
                        cal3[index13] = 9 * fat[index13] + 5 * (protein[index13] + carbs[index13]);
                        index13++;
                    }
                    int max7 = 0;
                    for (int i = 0; i < cal3.length; i++) {
                        if (cal3[i] > max7) {
                            max7 = carbs[i];
                            index = i;
                        }
                    }
                    for (int i = 0; i < cal3.length; i++) {
                        if (cal3[i] == max7) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
                case "t":
                    int index14 = 0;
                    int[] cal4 = new int[fat.length];
                    for (int i = 0; i < fat.length; i++) {
                        if (fat[index14] < 0 || protein[index14] < 0 || carbs[index14] < 0) {
                            cal4[index14] = 0;
                            index14++;
                            continue;
                        }
                        cal4[index14] = 9 * fat[index14] + 5 * (protein[index14] + carbs[index14]);
                        index14++;
                    }
                    int min7 = 0;
                    for (int i = 0; i < cal4.length; i++) {
                        if (cal4[i] != 0) {
                            min7 = cal4[i];
                            break;
                        }
                    }

                    for (int i = 0; i < cal4.length; i++) {
                        if (cal4[i] < min7 && cal4[i] > 0) {
                            min7 = cal4[i];
                            index = i;
                        }
                    }

                    for (int i = 0; i < cal4.length; i++) {
                        if (min7 == cal4[i]) {
                            if (i != index) {
                                rec = true;
                            }
                            a[i] = protein[i];
                            b[i] = carbs[i];
                            c[i] = fat[i];
                        }
                    }
                    break;
            }
            if (!rec) {
                return index;
            } else {
                String mid1 = "";
                for (int i = 1; i < dietPlans.length(); i++) {
                    mid1 += dietPlans.charAt(i);
                }
                return GetN(a, b, c, mid1);
            }

        }
    }
}