package DSApractice.Stack.Medium;

import GFG.Stack.Stock_span_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Online_Stock_Span_901 {

    // we store
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }

        stack.push(new int[]{price, res});
        return res;
    }



    // My approach
    List<Integer> arrmy = new ArrayList<>();
    Stack<Integer> s1my;
    int i = 0;
    public StockSpannerMy() {
        s1 = new Stack<>();
    }

    public int nextMy(int price) {
        arrmy.add(price);
        if (s1my.isEmpty()) {
            s1my.push(i);
            i++;
            return 1;
        }

        while(!s1my.isEmpty() && arrmy.get(s1my.peek()) <= price) {
            s1my.pop();
        }

        int span = s1my.isEmpty() ? i + 1 : i - s1my.peek();

        s1my.push(i);
        i++;
        return span;
    }
}