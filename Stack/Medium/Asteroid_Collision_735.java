package DSApractice.Stack.Medium;

import java.util.Stack;

public class Asteroid_Collision_735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int i : asteroids) {
            if (i > 0) {    // i is positive
                s.push(i);
            } else {        // i is negative
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)) {
                    s.pop();
                }

                if (s.isEmpty() || s.peek() < 0) {  // add the negative element is stack becomes (or is) empty
                    s.push(i);
                } else if (i + s.peek() == 0) {     // equal
                    s.pop();
                }
            }
        }

        int[] arr = new int[s.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = s.pop();
        }

        return arr;
    }
}