// https://leetcode.com/problems/flipping-an-image/

package DSApractice.LeetCode.Arrays.Easy;

public class Flipping_an_Image_832 {

    public int[][] flipAndInvertImage(int[][] image) {
        int[][] res = new int[image.length][image.length];

        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j <image.length; j++)
            {
                if (image[i][image.length - 1 - j] == 0)
                    res[i][j] = 1;
                else
                    res[i][j] = 0;
            }
        }

        return res;
    }
}
