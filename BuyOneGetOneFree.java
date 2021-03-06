/*
* Problem Statement

There are some items you want to purchase from a store. The prices of these items are given in the int[] prices.

You can purchase any item by paying its price.

However, the store also has a special sale today: "buy one, get one free". This means that whenever you bring a pair of items to the cash register, you only have to pay for the more expensive one and you'll get the other one for free as a bonus.

Given the prices, find the optimal shopping strategy and calculate the minimum you have to pay to purchase all the items you want.


Definition

Class:	BuyOneGetOneFree
Method:	buy
Parameters:	int[]
Returns:	int
Method signature:	int buy(int[] prices)
(be sure your method is public)


Constraints
-	prices will contain between 1 and 10 elements, inclusive.
-	Each element of prices will be between 1 and 1000, inclusive.

Examples
0)

{47}
Returns: 47
There is a single item you want. There is no way to use the sale, you just have to pay for it.
1)

{10, 20}
Returns: 20
You want two items. One costs 10, the other 20. You can use the sale to pay just 20 and get both of them.
2)

{10, 20, 30, 20}
Returns: 50
You can use the sale as many times as you want (of course, always buying two new items).
3)

{5, 7, 13, 2, 9}
Returns: 22
If you are clever, you will only pay 13 + 7 + 2 for these five items.
4)

{100, 100, 100, 100, 100, 100}
Returns: 300
If you take two items that cost the same, you can still pay for one of them and get the other one for free. These six items are best bought as three separate pairs.
* */
public class BuyOneGetOneFree {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 20};
        BuyOneGetOneFree bogof = new BuyOneGetOneFree();
        int result = bogof.buy(a);
        System.out.println(result);
    }

    public int buy(int[] a) {
        if (a.length == 1) {
            return a[0];
        } else {
            int res = 0;
            int large1 = 0;
            int large2 = 0;
            int local = 0;
            for (int i = 0; i < a.length; i++) {
                if (large1 < a[i]) {
                    large1 = a[i];
                    local = i;
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (i == local) {
                    continue;
                } else {
                    if (large2 < a[i] && large2 <= large1) {
                        large2 = a[i];
                    }
                }
            }
            if (a.length == 2) {
                return large1;
            } else {
                int[] mid = new int[a.length - 2];
                int index = 0;
                int number = 0;
                for (int i = 0; i < a.length; i++) {
                    if (a[i] == large1 || a[i] == large2 && number < 2) {
                        number++;
                        continue;
                    } else {
                        mid[index] = a[i];
                        index++;
                    }
                }
                return large1 + buy(mid);
            }
        }
    }
}