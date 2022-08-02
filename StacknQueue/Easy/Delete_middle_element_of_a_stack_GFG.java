package DSApractice.StacknQueue.Easy;

import java.util.Stack;

public class Delete_middle_element_of_a_stack_GFG {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);

        deleteMid(stack, 2);
    }

    static void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        Stack<Integer> stack = new Stack<>();
        sizeOfStack -= 1;
        sizeOfStack /= 2;

        while (!s.isEmpty()) {
            if (sizeOfStack == 0) {
                s.pop();
            }

            stack.push(s.peek());
            s.pop();

            sizeOfStack -= 1;
        }

        s.clear();

        while (!stack.isEmpty()) {
            s.push(stack.peek());
            stack.pop();
        }
    }
}