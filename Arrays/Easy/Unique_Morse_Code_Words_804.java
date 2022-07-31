// https://leetcode.com/problems/unique-morse-code-words/

package DSApractice.LeetCode.Arrays.Easy;

import java.util.HashSet;

public class Unique_Morse_Code_Words_804 {
    public static void main(String[] args) {
        String[] arr = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(arr));
    }

    static int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                s.append(arr[word.charAt(j) - 'a']);
            }
            set.add(s.toString());
        }

        return set.size();
    }
}
