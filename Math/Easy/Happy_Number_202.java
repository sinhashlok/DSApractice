//https://leetcode.com/problems/happy-number/

package DSApractice.Math.Easy;

public class Happy_Number_202 {

    /*
        we use cycle finding approach of linked list.

        there can be two cases :
            - either we get one, answer!
            - else the numbers start repeating, also slow == fast

            slow - square one time only
            fast - square two times
    */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSq(slow);
            fast = findSq(findSq(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }

        return false;
    }

    private int findSq(int n) {
        int ans = 0;

        while (n > 0) {
            int rem = n % 10;
            ans += (rem * rem);
            n /= 10;
        }

        return ans;
    }
}