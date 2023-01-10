package DSApractice.Strings.Easy;

import java.util.HashMap;
import java.util.Map;

public class Longest_Palindrome_409 {

    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int evenCount = 0;
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(int count : map.values()){
            evenCount += (count % 2 == 0) ? count : count-1;
        }

        return evenCount == s.length() ? evenCount : evenCount + 1;
    }
}