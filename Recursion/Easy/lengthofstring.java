/* https://www.geeksforgeeks.org/program-for-length-of-a-string-using-recursion/
    Given a string calculate length of the string using recursion.
*/
package DSApractice.LeetCode.Recursion.Easy;

public class lengthofstring {
    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";

        System.out.println(stringLength(s));
    }

    static int stringLength(String s) {
        if (s.equals(""))
            return 0;

        return stringLength(s.substring(1)) + 1;
    }
}
