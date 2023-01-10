package DSApractice.Strings.Medium;

public class Break_a_Palindrome_1328 {
    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
    }

    static String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        int i = 0;
        StringBuilder str = new StringBuilder();
        for (; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                str.append(palindrome.substring(0, i));
                str.append("a");
                str.append(palindrome.substring(i + 1, palindrome.length()));

                return str.toString();
            }
        }

        str.append(palindrome.substring(0, palindrome.length() - 1));
        str.append("b");

        return str.toString();
    }
}