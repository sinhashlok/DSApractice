package DSApractice.Strings.Easy;

public class Reverse_Vowels_of_a_String_345 {

    public String reverseVowels(String s) {
        int start = 0;
        int end  = s.length() - 1;
        char[] ch = s.toCharArray();

        while (start < end) {
            while (start < s.length () && !isVowel(ch[start])) {
                start++;
            }
            while (end >= 0 && !isVowel(ch[end])) {
                end--;
            }

            if (start < end) {
                swap(ch, start++, end--);
            }
        }

        return new String(ch);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }

    private void swap(char[] ch, int x, int y) {
        char temp = ch[x];
        ch[x] = ch[y];
        ch[y] = temp;
    }
}
