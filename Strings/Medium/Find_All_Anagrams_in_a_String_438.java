package DSApractice.Strings.Medium;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String_438 {

    // we will create 2 arrays. Array1 for string s & Array2 for string p. And their size would be 26.
    // They are storing the frequency of string s & string p.
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()) {
            return  list;
        }

        int N = s.length();
        int M = p.length();

        // initialize an array of size 26 (alphabets), which store the frequency of characters of p
        int[] count = freq(p);
        // for freq of s's characters, we store from 0 to M, initially.
        // And we keep updating the range as we keep moving left
        int[] currentCount = freq(s.substring(0, M));

        if(areSame(count,currentCount)) {
            list.add(0);
        }

        int i;
        for(i = M; i < N; i++) {
            // decrease the freq of left pointer character
            currentCount[s.charAt(i - M) - 'a']--;
            // increase the freq of new right pointer character
            currentCount[s.charAt(i)-'a']++;

            if(areSame(count, currentCount)) {
                list.add(i - M + 1);
            }
        }
        return list;
    }
    private boolean areSame(int[] x, int[] y){
        for(int i = 0; i < 26; i++){
            if(x[i] != y[i]) {
                return false;
            }
        }

        return true;
    }
    private int[] freq(String s){
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        return count;
    }
}

