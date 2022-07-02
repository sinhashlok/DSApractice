package DSApractice.LeetCode.Sorting;

public class LargestNumber_179 {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};

        System.out.println(largestNumber(nums));
    }

    static String largestNumber(int[] nums) {
        boolean[] num = new boolean[101];

        for (int k : nums)
            num[k] = true;

        StringBuilder str = new StringBuilder();

        for (int i = 9; i > 0; i--)
        {
            int cnt = 0;
            for (int j = (i * 10) + 9; j >= i*10; j--)
            {
                if (num[i])
                {
                    if (num[j] && (j > (i * 11)))
                        str.append(j);
                    else if (cnt == 0)
                    {
                        cnt += 1;
                        str.append(i);
                    }
                }
                else if (num[j])
                {
                    str.append(j);
                }
            }
        }

        return str.toString();
    }
}
