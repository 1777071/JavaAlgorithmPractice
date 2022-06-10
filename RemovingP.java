import java.util.Scanner;
import java.util.Stack;

public class RemovingP {
    public static void main(String[] args) {
        String a = "((()))(()(()))((()))";
        RemovingP pr = new RemovingP();
        int result = pr.countWays(a);
        System.out.println(result);
    }

    public int countWays(String a) {
        if (a.length() == 0) {
            return 1;
        } else {
            String mid = "";
            boolean judge = false;
            for (int i = 0; i < a.length(); i++) {
                if ((a.charAt(i) == '(') && (!judge)) {
                    judge = true;
                    continue;
                }
                mid += a.charAt(i);
            }
            int res = 0;
            String mid1 = "";
            for (int i = 0; i < mid.length(); i++) {
                if (mid.charAt(i) == ')') {
                    int indxe = i;
                    if (i != 0) {
                        mid1 = mid.substring(0, indxe) + mid.substring(indxe + 1);
                    } else {
                        mid1 = mid.substring(indxe + 1);
                    }
                    if (right(mid1)) {
                        res += countWays(mid1);
                    }

                }
            }
            return res;
        }
    }

    public boolean right(String a) {
        if (a == "") {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(') {
                stack.push(a.charAt(i));
            }
            if (a.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                }
                if (stack.peek() == '(' && a.charAt(i) == ')') {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}