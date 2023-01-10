package DSApractice.Strings.Medium;

public class Find_Kth_Bit_in_Nth_Binary_String_1545 {

    public char findKthBit(int n, int k) {
        String[] strs = new String[n];
        strs[0] = "0";

        for (int i = 1; i < n; i++) {
            strs[i] = formString(strs[i - 1]);
        }

        return strs[n - 1].charAt(k - 1);
    }

    private String formString(String strs) {
        return strs + "1" + reverse(invert(strs));
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String invert(String str) {
        StringBuilder s = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '1') {
                s.append('0');
            } else {
                s.append('1');
            }
        }

        return s.toString();
    }
}