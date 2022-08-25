package DSApractice.Sorting.Easy;

import java.util.Arrays;

public class Widest_Vertical_Area_Between_Two_Points_Containing_No_Points_1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);

        int res = x[1] - x[0];
        for (int i = 2; i < x.length; i++) {
            res = Math.max(res, x[i] - x[i - 1]);
        }

        return res;
    }
}