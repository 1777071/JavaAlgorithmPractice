/*
Problem Statement

Triangular numbers are numbers that can be obtained when counting items arranged into a triangle - in other words, they are sums of prefixes of the sequence of all positive integers.

The smallest few triangular numbers are 1, 3, 6, 10, 15, 21, ...



A permutation of order N is a sequence of length N that contains each of the numbers from 1 to N exactly once.

A permutation called a cyclic triangular permutation if it has the following property: if you place the elements of the permutation around a circle, each pair of adjacent elements would sum to a triangular number.

For example, {1, 2, 8, 7, 3, 12, 9, 6, 4, 11, 10, 5} is a cyclic triangular permutation. This is because 1+2, 2+8, 8+7, 7+3, ..., 10+5, and also 5+1 are all triangular numbers.



Given N, determine whether a cyclic triangular permutation of order N exists. If yes, return any one such permutation. If no, return an empty int[].


Definition

Class:	AllTriangles
Method:	construct
Parameters:	int
Returns:	int[]
Method signature:	int[] construct(int N)
(be sure your method is public)


Constraints
-	N will be between 2 and 200, inclusive.

Examples
0)

2
Returns: {1, 2 }
Both {1, 2} and {2, 1} are valid cyclic triangular permutations.
1)

3
Returns: { }
Regardless of how you place the numbers 1, 2, 3 onto a circle, 2 and 3 will be adjacent, and their sum 2+3 is not a triangular number.
2)

12
Returns: {1, 2, 8, 7, 3, 12, 9, 6, 4, 11, 10, 5 }
The example from the problem statement.
* */
public class AllTriangles {
    public static void main(String[] args) {
        int a = 12;
        AllTriangles at = new AllTriangles();
        int[] result = at.construct(a);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] construct(int a) {
        int[] res = new int[a];
        int[] tri = new int[99];
        int[] number = new int[a];
        boolean[] visited = new boolean[a];
        int[] wrongA = {};
        tri[0] = 1;
        //
        int count = 1;
        for (int i = 0; i < a; i++) {
            res[i] = 0;
            visited[i] = false;
            number[i] = count;
            count++;
        }

        //res[0] = 1;
        if (a == 1) {
            return res;
        }
        int bottom = 2;
        for (int i = 1; i < 99; i++) {
            tri[i] = tri[i - 1] + bottom;
            bottom++;
        }

        for (int i = 0; i < tri.length; i++) {
            if (a == tri[i]) {
                return wrongA;
            }
        }
        int mid = tri[0] - 0;
        int index = 0;
        for (int i = 0; i < a - 1; i++) {
            boolean jump = false;
            for (int j = 0; j < a; j++) {
                if (index == 0) {
                    mid = tri[i];
                } else {
                    mid = tri[i] - res[index - 1];
                }
                if (mid == number[j] && !visited[j]) {
                    visited[j] = true;
                    res[index] = mid;
                    index++;
                    i = 0;
//                    j=0;
//                    jump=true;
                }

                //System.out.println(tri[i+1]+" "+number[j]+" "+mid+" ========"+i);
            }
            System.out.println(mid + "+++++++++++");
        }
        for (int i = 0; i < a; i++) {
            System.out.println(res[i]);
        }
        boolean judge = false;
        for (int i = 0; i < a; i++) {
            if (res[i] == 0) {
                judge = true;
                break;
            }
        }
        if (judge) {
            return wrongA;
        } else {
            return res;

        }

    }
}
