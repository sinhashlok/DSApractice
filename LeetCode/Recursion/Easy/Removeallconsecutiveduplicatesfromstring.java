/* https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/

Recursive Solution:
    If the string is empty, return.
    Else compare the adjacent characters of the string. If they are same then shift the characters
    one by one to the left. Call recursion on string S
    If they not same then call recursion from S+1 string.
 */
package DSApractice.LeetCode.Recursion.Easy;

public class Removeallconsecutiveduplicatesfromstring {
    public static void main(String[] args) {
        String S1 = "geeksforgeeks";
        System.out.println(removeConsecutiveDuplicates(S1));

        String S2 = "aabcca";
        System.out.println(removeConsecutiveDuplicates(S2));
    }

    static String removeConsecutiveDuplicates(String input) {
        if(input.length()<=1)
            return input;
        if(input.charAt(0)==input.charAt(1))
            return removeConsecutiveDuplicates(input.substring(1));
        else
            return input.charAt(0) + removeConsecutiveDuplicates(input.substring(1));
    }
}
