package DSApractice.LeetCode.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber_17 {
    public static void main(String[] args) {
        String digits = "23";

        List<String> list = letterCombinations(digits);

        for (String s : list)
            System.out.println(s);
    }

    static List<String> letterCombinations(String digits) {
        return combination("", digits);
    }

    static List<String> combination(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0'; // this will convert '2' to 2

        List<String> list = new ArrayList<>();

        if (digit == 7) {
            for (int i = 15; i <= 18; i++) {
                char ch = (char)('a' + i);
                list.addAll(combination(p + ch, up.substring(1)));
            }
        } else if (digit == 9) {
            for (int i = 22; i <= 25; i++) {
                char ch = (char)('a' + i);
                list.addAll(combination(p + ch, up.substring(1)));
            }
        } else if (digit == 8) {
            for (int i = 19; i <= 21; i++) {
                char ch = (char)('a' + i);
                list.addAll(combination(p + ch, up.substring(1)));
            }
        } else {
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                char ch = (char)('a' + i);
                list.addAll(combination(p + ch, up.substring(1)));
            }
        }

        return list;
    }
}
