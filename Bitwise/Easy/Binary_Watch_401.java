// https://leetcode.com/problems/binary-watch/

package DSApractice.LeetCode.Bitwise.Easy;

import java.util.ArrayList;
import java.util.List;

public class Binary_Watch_401 {
    public static void main(String[] args) {
//        List<String> list = readBinaryWatch(1);   // backtrack based
        List<String> list1 = readBinaryWatchLeet(5);    // bitCount method
//        System.out.println(list);
        System.out.println(list1);
    }

    static List<String> readBinaryWatchLeet(int turnedOn) {
        ArrayList<String> res = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                // the below condition (bitCount check number of set bits), if the total is equal to turnedOn, then go on
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    if (minute < 10) {
                        res.add(hour + ":0" + minute);
                    } else {
                        res.add(hour + ":" + minute);
                    }
                }
            }
        }

        return res;
    }

    static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[] {8, 4, 2, 1}, nums2 = new int[] {32, 16, 8, 4, 2, 1};

        for(int i = 0; i <= turnedOn; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, turnedOn - i);

            for(int num1: list1) {
                if(num1 >= 12) continue;

                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }

        return res;
    }
    private static List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }
    private static void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }

        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }
}