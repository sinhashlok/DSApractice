/* https://www.geeksforgeeks.org/first-uppercase-letter-in-a-string-iterative-and-recursive/
    Given a string find its first uppercase letter
*/

package DSApractice.LeetCode.Recursion.Easy;

public class Firstuppercaseletterinstring {
    public static void main(String[] args) {
        String s = "geeksforgeeKs";

//        System.out.println(iterativeApproach(s));
        System.out.println(recursiveApproach(s, 0));
    }

    static char iterativeApproach(String s) {
        for (int i = 0; i < s.length(); i++)
            if (Character.isUpperCase(s.charAt(i)))
                return s.charAt(i);

        return (char)(-1);
    }

    static char recursiveApproach(String s, int i) {
        if (i == s.length())
            return (char)(-1);

        if (Character.isUpperCase(s.charAt(i)))
            return s.charAt(i);
        else
            return recursiveApproach(s, i + 1);
    }
}
