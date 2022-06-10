import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class RowAndManyCoins {
    public String getWinner(String cells) {
        int n = cells.length();
        if (cells.charAt(0) == 'A' && cells.charAt(n - 1) == 'A') return "Alice";
        if (cells.charAt(0) == 'A' && cells.charAt(n - 1) == 'B') return "Alice";
        if (cells.charAt(0) == 'B' && cells.charAt(n - 1) == 'A') return "Alice";
        if (cells.charAt(0) == 'B' && cells.charAt(n - 1) == 'B') return "Bob";
        return "";
    }


}