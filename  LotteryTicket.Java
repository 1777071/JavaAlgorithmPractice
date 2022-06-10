import java.util.ArrayList;
/*
 Problem Statement for LotteryTicket


Problem Statement
    	Nick likes to play the lottery. The cost of a single lottery ticket is price. Nick has exactly four banknotes with values b1, b2, b3 and b4 (some of the values may be equal). He wants to know if it's possible to buy a single lottery ticket without getting any change back. In other words, he wants to pay the exact price of a ticket using any subset of his banknotes. Return "POSSIBLE" if it is possible or "IMPOSSIBLE" if it is not (all quotes for clarity).

Definition

Class:	LotteryTicket
Method:	buy
Parameters:	int, int, int, int, int
Returns:	String
Method signature:	String buy(int price, int b1, int b2, int b3, int b4)
(be sure your method is public)


Constraints
-	price will be between 1 and 4000, inclusive.
-	b1, b2, b3 and b4 will each be between 1 and 1000, inclusive.

Examples
0)

10
1
5
10
50
Returns: "POSSIBLE"
Nick can use the banknote with value b3.
1)

15
1
5
10
50
Returns: "POSSIBLE"
Here he can use the banknotes with values b2 and b3.
2)

65
1
5
10
50
Returns: "POSSIBLE"
b2 + b3 + b4 is 65.
3)

66
1
5
10
50
Returns: "POSSIBLE"
All four banknotes must be used.
4)

1000
999
998
997
996
Returns: "IMPOSSIBLE"
5)

20
5
5
5
5
Returns: "POSSIBLE"
Some of the banknote values may be equal.
6)

2
1
5
10
50
Returns: "IMPOSSIBLE"
*/

public class LotteryTicket {
    ArrayList<Integer> middle = new ArrayList<Integer>();

    public static void main(String[] args) {
        int a = 16;
        int b = 1;
        int c = 5;
        int d = 10;
        int e = 50;
        LotteryTicket lt = new LotteryTicket();
        String result = lt.buy(a, b, c, d, e);
        System.out.println(result);
    }

    public String buy(int a, int b, int c, int d, int e) {
        if ((a == b) || (a == c) || (a == d) || (a == e) || (a == (b + c + d + e))) {
            return "Possible";
        } else {

            int[] mid = {b, c, d, e};
            for (int i = 2; i < 5; i++) {
                int[] judge = wh(mid, i);
                for (int j = 0; j < middle.size(); j++) {
                    if (middle.get(j) == a) {
                        return "Possible";
                    }
                }
            }
            for (int i = 0; i < middle.size(); i++) {
                System.out.println(middle.get(i));
            }
            return "Impossible";
        }
    }

    public int[] wh(int[] mid, int m) {
        if (m == 2) {
            int len = 0;
            for (int i = 1; i < mid.length; i++) {
                len += i;
            }
            int[] temp1 = new int[len];
            int index1 = 0;
            for (int i = 0; i < mid.length; i++) {
                for (int j = 0; j < mid.length; j++) {
                    if (j == i) {
                        continue;
                    } else {
                        boolean have = false;
                        boolean have1 = false;
                        for (int k = 0; k < middle.size(); k++) {
                            if ((mid[i] + mid[j]) == middle.get(k)) {
                                have = true;
                                break;
                            }
                        }
                        if (!have) {
                            middle.add(mid[i] + mid[j]);
                        }
                        for (int k = 0; k < temp1.length; k++) {
                            if (mid[i] + mid[j] == temp1[k]) {
                                have1 = true;
                                break;
                            }
                        }
                        if (!have1) {
                            temp1[index1] = mid[i] + mid[j];
                            index1++;
                        }

                    }
                }
            }
            return temp1;
        } else {
            int[] res = new int[mid.length - 1];
            int temp = 0;
            int index = 0;
            for (int i = 0; i < mid.length; i++) {
                for (int j = 0; j < mid.length; j++) {
                    if (j == i) {
                        temp = mid[j];
                    } else {
                        res[index] = mid[j];
                        index++;
                    }
                }
                int[] temp2 = wh(res, m - 1);
                for (int j = 0; j < temp2.length; j++) {
                    boolean have = false;
                    for (int k = 0; k < middle.size(); k++) {
                        if ((temp + temp2[j]) == middle.get(k)) {
                            have = true;
                            break;
                        }
                    }
                    if (!have) {
                        middle.add(temp + temp2[j]);
                    }
                }
                for (int j = 0; j < res.length; j++) {
                    res[j] = 0;
                }
                index = 0;
            }
            return res;
        }
    }
}