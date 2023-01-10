// https://leetcode.com/problems/add-binary/

package DSApractice.Bitwise.Easy;

public class Add_Binary_67 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    static String addBinary (String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // we create a carry, as we have to consider it as well

        while(i >= 0 || j >= 0){
            int sum = carry;

            // Now, we subtract by '0' to convert the numbers from a char type into an int, so we can perform operations on the numbers
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            // taking carry;
            carry = sum > 1 ? 1 : 0;
            // getting carry depend on the quotient we get by dividing
            // sum / 2 that will be our carry. Carry could be either 1 or 0
            // if sum is 0 res is 1 & then carry would be 0;
            // if sum is 1 res is 1 & carry would be 0
            // if sum is 2 res is 0 & carry would be 1
            // if sum is 3 res is 1 & carry would be 1
            res.append(sum % 2);
        }

        if(carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

}