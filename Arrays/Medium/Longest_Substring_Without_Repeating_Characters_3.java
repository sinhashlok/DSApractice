package DSApractice.Arrays.Medium;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters_3 {

    public  int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;

        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            ans = Math.max(ans,i - j + 1);
        }

        return ans;
    }
}