package DSApractice.Recursion.Medium;

public class Find_Kth_Bit_in_Nth_Binary_String_1545 {

    public char findKthBit(int n, int k) {
        if (n == 1) {   // base case
            return '0';
        }

        int mid = ((int)Math.pow(2,n) + 1) / 2;

        if (k < mid) {
            return findKthBit(n - 1, k);
        } else if (k == mid) {
            return '1';
        }

        int prevLen = mid - 1;  // length of previous level
        int prevBitPosFromStart = k - mid;

        // this will give the position bit whose inverse is the current node's k value
        // but this will be from starting so to obtain it from the end(because it was
        // reversed), we need to subtract it from the prevLen and then, add one to it
        return findKthBit(n - 1, prevLen - prevBitPosFromStart + 1) == '0' ? '1' : '0';
    }
}