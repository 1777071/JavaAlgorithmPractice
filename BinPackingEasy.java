/*
* Problem Statement
    	Fox Ciel has some items. The weight of the i-th (0-based) item is item[i]. She wants to put all items into bins.



The capacity of each bin is 300. She can put an arbitrary number of items into a single bin, but the total weight of items in a bin must be less than or equal to 300.



You are given the int[] item. It is known that the weight of each item is between 101 and 300, inclusive. Return the minimal number of bins required to store all items.

Definition

Class:	BinPackingEasy
Method:	minBins
Parameters:	int[]
Returns:	int
Method signature:	int minBins(int[] item)
(be sure your method is public)


Constraints
-	item will contain between 1 and 50 elements, inclusive.
-	Each element of item will be between 101 and 300, inclusive.

Examples
0)

{150, 150, 150, 150, 150}
Returns: 3
You have five items and each bin can hold at most two of them. You need at least three bins.
1)

{130, 140, 150, 160}
Returns: 2
For example, you can distribute the items in the following way:
Bin 1: 130, 150
Bin 2: 140, 160
2)

{101, 101, 101, 101, 101, 101, 101, 101, 101}
Returns: 5
3)

{101, 200, 101, 101, 101, 101, 200, 101, 200}
Returns: 6
4)

{123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198}
Returns: 8*/
public class BinPackingEasy {
    public static void main(String[] args) {
        int[] a = {101, 101, 101, 101, 101, 101, 101, 101, 101};
        BinPackingEasy bpe = new BinPackingEasy();
        int result = bpe.minBins(a);
        System.out.println(result);
    }

    public int minBins(int[] b) {
        int res = 0;
        boolean[] visited = new boolean[b.length];
        for (int i = 0; i < b.length; i++) {
            if (b[i] > 200) {
                res++;
                visited[i] = true;
                continue;
            }

            int index = 0;
            int mid = 300 - b[i];
            int start = 9999999;
            boolean jump = false;
            for (int j = 0; j < b.length; j++) {
                if (j == i || visited[j]) {
                    continue;
                }
                if (mid - b[j] >= 0 && mid - b[j] < start) {
                    index = j;
                    start = mid - b[j];
                    jump = true;
                }
            }

            if (jump && !visited[i]) {
                System.out.println(index + "======" + i);
                visited[index] = true;
                visited[i] = true;
                res++;
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                res++;
            }
        }
        return res;
    }
}