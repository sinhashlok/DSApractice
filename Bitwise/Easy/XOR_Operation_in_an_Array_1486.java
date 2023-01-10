// https://leetcode.com/problems/xor-operation-in-an-array/

package DSApractice.Bitwise.Easy;

public class XOR_Operation_in_an_Array_1486 {

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= (start + (2*i) );
        }

        return res;
    }
}