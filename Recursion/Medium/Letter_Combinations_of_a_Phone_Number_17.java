package DSApractice.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number_17 {

    private final String[] str = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        return letter("", digits);
    }

    private List<String> letter(String p, String digits) {
        if (digits.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        char ch = digits.charAt(0);
        int n = (int)(ch - '0') - 1;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str[n].length(); i++) {
            char c = str[n].charAt(i);
            list.addAll(letter(p + c, digits.substring(1)));
        }

        return list;
    }
}