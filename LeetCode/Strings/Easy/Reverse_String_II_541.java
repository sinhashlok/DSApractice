// https://leetcode.com/problems/reverse-string-ii/

package DSApractice.LeetCode.Strings.Easy;

public class Reverse_String_II_541 {

    // Leetcode
    static String reverseStrLEET(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    // MY approach
    static String reverseStrMY(String s, int k) {
        StringBuilder res = new StringBuilder();
        if (k > s.length()) {
            return res.append(s).reverse().toString();
        }

        StringBuilder str = new StringBuilder();
        while (s.length() != 0) {
            if (s.length() < k) {
                str.append(s).reverse();
                res.append(str);
                str.setLength(0);
                break;

            } else {
                str.append(s.substring(0,k)).reverse();
                res.append(str);
                str.setLength(0);
                s = s.substring(k);
            }

            if (s.length() < k) {
                res.append(s);
                break;
            } else {
                res.append(s.substring(0,k));
                s = s.substring(k);
            }
        }

        return res.toString();
    }
}
