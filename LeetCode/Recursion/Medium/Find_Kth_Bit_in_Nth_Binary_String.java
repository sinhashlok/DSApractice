// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

package DSApractice.LeetCode.Recursion.Medium;

public class Find_Kth_Bit_in_Nth_Binary_String {
    static String ans = "";
    public static void main(String[] args) {
        System.out.print(findKthBit(2, 1048575));
    }

    static char findKthBit(int n, int k) {
        String s = "";
        formString(n, 0, s, k);

        return ans.charAt(k-1);
    }

    static void formString(int n, int i, String s, int k) {
        if (i == 0) {
            s = s + "0";
        }
        if (k <= s.length()) {
            ans = s;
            System.out.println(s);
            return;
        }
//        if (n == 1) {
//            ans = s;
//            System.out.println(s);
//            return;
//        }

        formString(n - 1 , i + 1, s + "1" + invert(s), k);
    }

    static String invert(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                s = s.substring(0, i) + '0' + s.substring(i + 1);
            } else {
                s = s.substring(0, i) + '1' + s.substring(i + 1);
            }
        }

        StringBuilder input =  new StringBuilder();
        input.append(s);
        input.reverse();

        s = String.valueOf(input);
        return s;
    }
}
