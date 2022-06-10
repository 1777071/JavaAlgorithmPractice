public class Catchphrase {
    public static void main(String[] args) {
        int a = 1000;
        int b = 800;
        Catchphrase cp = new Catchphrase();
        int result = cp.reconstruct(a, b);
        System.out.println(result);
    }

    public int reconstruct(int a, int b) {
        int firstC = 9;
        int secondC = 9;
        int count = 0;
        boolean acg = false;
        boolean bcg = false;
        boolean firstFund = false;
        boolean secondFund = false;

        if (b > 1000) {
            //the fund scores
            b -= 1000;
            secondFund = true;
        }
        if (b > 500) {
            b -= 500;
            firstFund = true;
        }

        for (int i = 0; i < 99; i++) {
            if (b < 500) {
                break;
            }
            b -= 500;
        }
        int secN = b % 200;
        if (secN % 100 != 0) {
            return -1;
        }
        for (int i = 0; i < 9; i++) {
            if (b < 200) {
                break;
            }
            secondC--;
            b -= 200;
        }
        firstC -= secN / 100;

        if (!firstFund) {
            a -= 500;
            count++;
            firstFund = true;
        }
        //System.out.println(firstFund+" "+count);
        if (!secondFund) {
            a -= 1000;
            count++;
            secondFund = true;
        }
        if (!secondFund || !firstFund) {
            return -1;
        }
        if (a < 0 || a % 100 != 0) {
            return -1;
        }
        int res = 100 * firstC + 200 * secondC;
        if (a < res) {

            for (int i = 0; i < firstC; i++) {
                if (a == 0) {
                    return count;
                }
                a -= 100;
                count++;
            }
            //System.out.println(a+"======="+count);
            if (a % 200 == 100) {
                a += 100;
                count--;
                for (int i = 0; i < secondC; i++) {
                    if (a == 0) {
                        return count;
                    }
                    a -= 200;
                    count++;
                }
                if (a > 0) {
                    return count - 2;
                }
            } else {
                for (int i = 0; i < secondC; i++) {
                    if (a == 0) {
                        return count;
                    }
                    a -= 200;
                    count++;
                }
            }
        } else {

            if (a == res) {
                return firstC + secondC;
            } else {
                count += firstC + secondC;
                //System.out.println(a+"============="+count);
                int FHN = a - res;
                //System.out.println(FHN+"============="+res);
                int GetFive = FHN % 500;
                switch (GetFive) {
                    case 0:
                        count += FHN / 500;
                    case 100:
                        count -= 2;
                        count += (FHN + 400) / 500;
                        break;
                    case 200:
                        count -= 2;
                        //System.out.println(FHN+"=========="+count);
                        count += (FHN + 300) / 500;
                        break;
                    case 300:
                        count--;
                        count += (FHN + 200) / 500;
                        break;
                    case 400:
                        count--;
                        count += (FHN + 100) / 500;
                        break;
                }
                return count;
            }
        }
        return 999999;
    }
}