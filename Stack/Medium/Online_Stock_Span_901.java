package DSApractice.Stack.Medium;

import GFG.Stack.Stock_span_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Online_Stock_Span_901 {

    // we store the price as well the number of stock price less than it in a stack of array
    // stack (arr[price, res])
    // res - number of stocks less the price
    Stack<int[]> stack;
    public void StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;

        // while previous larger price is lower than current new stock price, keep removing it from array
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }

        // now add the current new price and the number of stocks less that it consecutively (minimum 1) than price in stack
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