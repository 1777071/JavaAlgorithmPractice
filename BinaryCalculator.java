/*
Problem Statement

You have a very simple calculator that has a display and two buttons. The buttons are labelled "-2" and "+3". Whenever you press a button, the corresponding operation is applied to the number shown on the display. For example, if the display shows the number 10, pressing the "-2" button changes it to 10-2 = 8, while pressing the "+3" button changes it to 10+3 = 13.

You are given the ints a and b. The display currently shows the integer a. You would like to change the displayed number to b. Calculate and return the smallest total number of buttons you need to press.


Definition

Class:	BinaryCalculator
Method:	minimumSteps
Parameters:	int, int
Returns:	int
Method signature:	int minimumSteps(int a, int b)
(be sure your method is public)


Constraints
-	a will be between 1 and 100, inclusive.
-	b will be between 1 and 100, inclusive.

Examples
0)

10
14
Returns: 3
One solution is to press the button +3 to get 13, then -2 to get 11 and finally +3 to get 14. There are other ways of obtaining the same result, but none of them is shorter than 3 presses.
1)

23
23
Returns: 0
As a = b, you don't need to press any buttons.
2)

18
12
Returns: 3
The only optimal solution is to press "-2" three times in a row.
3)

23
62
Returns: 13

* */
public class BinaryCalculator {
    public static void main(String[] args) {
        int a = 9;
        int b = 2;
        BinaryCalculator bc = new BinaryCalculator();
        int result = bc.minimumSteps(a, b);
        System.out.println(result);
    }

    public int minimumSteps(int a, int b) {
        if (a == b) {
            return 0;
        } else {
            if (a < b) {
                int num = (b - a) % 3;
                if (num == 0) {
                    return (b - a) / 3;
                } else {
                    if (num == 1) {
                        return 2 + (b - a) / 3;
                    } else {
                        return 4 + (b - a) / 3;
                    }
                }
            } else {
                int num1 = (a - b) % 2;
                if (num1 == 0) {
                    return (a - b) / 2;
                } else {
                    if (num1 == 1) {
                        return 3 + (a - b) / 2;
                    }
                }
            }
        }
        return 0;
    }
}