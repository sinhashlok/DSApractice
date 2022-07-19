// https://leetcode.com/problems/valid-palindrome/submissions/

package DSApractice.LeetCode.Strings.Easy;

public class Valid_Palindrome_125 {

        // My Approach
    static boolean isPalindromeMY(String s) {
        StringBuilder str = new StringBuilder();
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0)
                str.append(s.charAt(i));

            if (Character.isAlphabetic(s.charAt(i))) {
                str.append(s.charAt(i));
            }
        }


        if (str.toString().equals(str.reverse().toString())) {
            return true;
        }

        return false;
    }

    // Better Approach
    public class Solution {
        public boolean isPalindrome(String s) {
            if (s.isEmpty()) {
                return true;
            }
            int head = 0, tail = s.length() - 1;
            char cHead, cTail;
            while(head <= tail) {
                cHead = s.charAt(head);
                cTail = s.charAt(tail);
                if (!Character.isLetterOrDigit(cHead)) {
                    head++;
                } else if(!Character.isLetterOrDigit(cTail)) {
                    tail--;
                } else {
                    if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                        return false;
                    }
                    head++;
                    tail--;
                }
            }

            return true;
        }
    }

}
