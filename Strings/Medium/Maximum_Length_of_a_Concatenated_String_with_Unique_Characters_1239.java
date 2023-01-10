package DSApractice.Strings.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters_1239 {

    private int len = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        helper(arr, "", 0);

        return len;
    }

    private void helper(List<String> arr, String up, int i) {
        boolean uniq = isUniq(up);

        if (uniq) {
            len = Math.max(len, up.length());
        }

        if (i == arr.size() || !uniq) {
            return;
        }

        for (int j = i; j < arr.size(); j++) {
            helper(arr, up + arr.get(j), i + 1);
        }
    }

    private boolean isUniq(String str) {
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }

            set.add(c);
        }

        return true;
    }
}