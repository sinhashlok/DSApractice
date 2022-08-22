package DSApractice.Stack.Medium;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        /*
        * when we fill the result array, two seniors occur
        * 1. Current temp is less that next days -> put 1, as only one day need for greater temp
        * 2. next day temperature is less,
        *   NOW
        *   # we see the ans on next day's temperature, say 2 it is
        *   # so now we skip two positions in temp and compare with that temperature with current day's temp
        *   # if greater -> add that temperatures index
        *   # else keep moving right, till you go out of bound for which put index as 0, for current temp
        * */
        int[] arr = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; --i) {
            int j = i + 1;

            while (j < temperatures.length && temperatures[j] <= temperatures[i]) {
                if (arr[j] > 0) {
                    j = arr[j] + j;
                } else {
                    j = temperatures.length;
                }

            }

            if (j < temperatures.length) {
                arr[i] = j - i;
            }
        }
        return arr;
    }

    // Stack approach
    public int[] dailyTemperaturesStack(int[] temperatures) {
        // we traverse the array from righ to left

        Stack<Integer> indexs = new Stack<>();
        // this stores the index of the greatest element from right as we keep moving left

        int[] arr = new int[temperatures.length];
        // this store the answer

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (indexs.isEmpty()) {
                indexs.push(i);
                arr[i] = 0;
                continue;
            }

            while(!indexs.isEmpty() && temperatures[indexs.peek()] <= temperatures[i]) {
                indexs.pop();
            }

            int index = indexs.isEmpty() ? 0 : indexs.peek() - i;
            arr[i] = index;

            indexs.push(i);
        }

        return arr;
    }
}