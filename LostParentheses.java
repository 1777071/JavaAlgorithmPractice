import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class LostParentheses {
    public int minResult(String e) {
        String ee = e.replaceAll("[+-]", " ");
        String[] nums1 = ee.split(" ");
        ee = e.replaceAll("[^+-]", "");
        int[] nums = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            nums[i] = Integer.parseInt(nums1[i]);
        int sum = 0;
        boolean b = false;
        for (int i = 0; i < nums.length; i++) {
            if (!b) sum += nums[i];
            else sum -= nums[i];
            if (i < ee.length() && ee.charAt(i) == '-')
                b = true;
        }
        return sum;
    }


}