package DSApractice.StacknQueue.Easy;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates_In_String_1047 {

        // LeetCode
    // here we use StringBuilder as a stack
    public String removeDuplicatesLeet(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int size = sb.length();

            if (size > 0 && sb.charAt(size - 1) == c) { // if element exists remove it
                sb.deleteCharAt(size - 1);
            }
            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

        // My Code
    static String removeDuplicatesMy(String s) {
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
            }
            else if (stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }

            i++;
        }

        StringBuilder str = new StringBuilder();

        for(char st : stack) str.append(st);

        return str.toString();
    }
}