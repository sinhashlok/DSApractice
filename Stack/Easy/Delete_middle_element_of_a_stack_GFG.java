package DSApractice.Stack.Easy;

import java.util.Stack;

public class Delete_middle_element_of_a_stack_GFG {

    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        Stack<Integer> stack = new Stack<>();
        sizeOfStack /= 2;

        while (!s.isEmpty()) {
            stack.push(s.peek());
            s.pop();

            sizeOfStack -= 1;
            if (sizeOfStack == 0) {
                s.pop();
            }
        }

        s.clear();

        while (!stack.isEmpty()) {
            s.push(stack.peek());
            stack.pop();
        }
    }
}