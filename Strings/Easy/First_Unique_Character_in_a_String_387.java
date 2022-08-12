package DSApractice.Strings.Easy;

public class First_Unique_Character_in_a_String_387 {

        // My approach
    public int firstUniqCharMy(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

        // slightly faster
    public int firstUniqChar(String s) {
        int[] alp = new int[26];
        char[] arr = s.toCharArray();   // make character array of string s

        for(char c : arr ) {
            alp[c - 'a']++;
        }

        for(int i = 0; i < arr.length; i++){
            if (alp[arr[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}