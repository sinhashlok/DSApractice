package DSApractice.Strings.Medium;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters_3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0, r = 0, ans = 0;

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(l++));
            }
        }

        return ans;
    }
}