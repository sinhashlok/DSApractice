package DSApractice.Strings.Medium;

import java.util.Stack;

public class Decode_String_394 {

    public String decodeString(String s) {
        // Counts - store the just previous number - number of times the element is to be printed
        Stack<Integer> counts = new Stack<>();

        // result - stores the final string
        Stack<String> result = new Stack<>();

        String res = "";
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {   // check is character is digit
                int count = 0;

                // below loop keeps adding number to count (with appropriate decimal places)
                // while the numbers keeps occurring simultaneously
                while (Character.isDigit(s.charAt(index))) {
                    count = (10 * count) + (s.charAt(index) - '0');
                    index += 1;
                }

                // push the latest number to counts (stack)
                counts.push(count);
            } else if (s.charAt(index) == '[') {    // check for opening bracket
                result.push(res);
                res = "";
                // here we push the latest string (
                // and update the string to empty

                index += 1;
            } else if (s.charAt(index) == ']') {    // closed bracket
                // temp - stores the total string
                StringBuilder temp = new StringBuilder(result.pop());
                // count - store the number of times the latest string it to repeat
                int count = counts.pop();

                // adds current s
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }

                // res - now stores the total string
                res = temp.toString();
                index += 1;
            } else {    // add character to string
                res += s.charAt(index);
                index += 1;
            }
        }

        return res;
    }
}