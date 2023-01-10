// https://leetcode.com/problems/count-the-number-of-consistent-strings/

package DSApractice.Bitwise.Easy;

public class Count_the_Number_of_Consistent_Strings_1684 {

    /*  LeetCode
    * We can create a Boolean array of 26 and mark the allowed alphabets true if present and false otherwise.
    * Because alphabet is of type int it has 32 bits and we need 26(think Why?) so ,a single int will be enough
    * instead of an array to deduce whether an alphabet is allowed or not.

        Now how to store information:
        You see initially alphabet is 0. Its binary form is 00000........
        Now we set the LSB(Least Significant Bit) to 1 to represent that a is allowed. ........00001 => means only a is allowed
        Similarly we set the second last bit to 1 to represent that b is allowed. ......000010 => means only b is allowed
        ......0000011 => this means a and b are both allowed
        If an alphabet is not allowed we skip it. (it remains 0)

        * Let's take an example allowed = "acdg"
        alphabet initially is 0(...00000)
        for a it will become ...00001
        then for c ...00101
        for d ....001101
        at last for g .....001001101
    * */
    public int countConsistentStringsLeet(String allowed, String[] words) {
        int alpha = 0, count = 0;
        for (int i = 0; i < allowed.length(); i++) {
            int shift = allowed.charAt(i) - 'a';
            alpha |= (1 << shift);
        }

        for (String w : words) {
            boolean flag = true;

            for (int i = 0; i < w.length(); ++i) {
                if ((alpha & (1 << w.charAt(i) - 'a')) == 0) {
                    flag = false;
                    break;
                }
            }

            count += flag ? 1 : 0;
        }

        return count;
    }

        // My code
    public int countConsistentStringsMy(String allowed, String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            int j = 0;

            while (j < words[i].length()) {
                char ch = words[i].charAt(j);
                j++;
                if (!allowed.contains(ch + "")) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count ++;
            }
        }

        return count;
    }
}