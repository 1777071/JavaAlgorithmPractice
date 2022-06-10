public class lastexam {
    public static void main(String[] args) {
        String a = "??????";
        lastexam last = new lastexam();
        int result = last.maxDistance(a);
        System.out.println(result);
    }

    public int maxDistance(String program) {
        int Ln = 0;
        int Rn = 0;
        int L = 0;
        int R = 0;
        int unN = 0;
        int Lmax = 0;
        int Rmax = 0;
        for (int i = 0; i < program.length(); i++) {
            if (program.charAt(i) == 'L') {
                Ln++;
                L++;
                if (Rmax < Rn) {
                    Rmax = Rn;
                }
                if (Ln > Lmax) {
                    Lmax = Ln;
                }
                Rn--;
            }
            if (program.charAt(i) == 'R') {
                Rn++;
                R++;
                if (Lmax < Ln) {
                    Lmax = Ln;
                }
                if (Rn > Rmax) {
                    Rmax = Rn;
                }
                Ln--;
            }
            if (program.charAt(i) == '?') {
                unN++;
            }
        }

        if (unN > 0 && Lmax > Rmax && L != 1 && R != 1) {
            Lmax = unN + Lmax;
        } else {
            if (unN > 0 && Lmax < Rmax && L != 1 && R != 1) {
                Rmax = unN + Rmax;
            } else {
                if (unN > 0 && Lmax == Rmax && L != 1 && R != 1) {
                    Rmax = Rmax + unN;
                } else {
                    if (unN > 0 && (L == 1 && R == 1)) {
                        Rmax = unN + 1;
                    } else {
                        if (unN > 0 && L == 0 && R == 0) {
                            Rmax = unN;
                        }
                    }
                }
            }
        }
        if (Rmax > Lmax) {
            return Rmax;
        } else {
            return Lmax;
        }


    }
}