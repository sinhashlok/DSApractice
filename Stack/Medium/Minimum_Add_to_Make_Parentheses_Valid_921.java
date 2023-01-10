package DSApractice.Stack.Medium;

public class Minimum_Add_to_Make_Parentheses_Valid_921 {

    /*
    * left records the number of ( we need to add on the left of S.
    * right records the number of ) we need to add on the right of S,
    *
    * if (c == '('), we increment right,
    * if (c == ')'), we decrement right.
    * When right is already 0, we increment left
    * Return left + right in the end
    * */
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }

        return left + right;
    }
}