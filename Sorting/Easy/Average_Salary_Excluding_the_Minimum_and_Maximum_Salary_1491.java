// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

package DSApractice.LeetCode.Sorting.Easy;

public class Average_Salary_Excluding_the_Minimum_and_Maximum_Salary_1491 {

    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = 0;
        double sum = 0;

        for (int n : salary) {
            min = Math.min(min, n);
            max = Math.max(max, n);
            sum += n;
        }

        sum -= (min + max);

        return sum / (salary.length - 2);
    }

}