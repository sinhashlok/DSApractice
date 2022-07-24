// https://leetcode.com/problems/maximum-repeating-substring/

package DSApractice.LeetCode.Strings.Easy;

public class Maximum_Repeating_Substring_1668 {
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
//        System.out.println(maxRepeating("ababc", "ac"));
    }

    static int maxRepeating(String sequence, String word) {
        StringBuilder find = new StringBuilder(); // create an empty string that will store the longest repeating substring
        find.append("");
        while (sequence.contains(find.toString())) {    // every time we increment the find with word
            find.append(word);
        }

        return (find.length() - word.length()) / word.length(); // -1 for the first increment
    }
}
