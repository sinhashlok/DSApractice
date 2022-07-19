package DSApractice.LeetCode.Strings.Easy;

public class Determine_if_String_Halves_Are_Alike_1704 {

    static boolean halvesAreAlike(String s) {
        int n = s.length() / 2;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            count1 += (check(s.charAt(i)) ? 1 : 0);
        }

        for (int i = n; i < s.length(); i++) {
            count2 += (check(s.charAt(i)) ? 1 : 0);
        }

        return (count1 == count2);
    }

    static boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
