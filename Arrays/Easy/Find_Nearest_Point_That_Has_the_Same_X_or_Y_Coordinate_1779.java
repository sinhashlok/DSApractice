package DSApractice.Arrays.Easy;

public class Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate_1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE, index =- 1;
        int i;

        for (i = 0; i < points.length; i++) {
            if (x == points[i][0] ||  y == points[i][1]) {
                int d = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);

                if (d < min) {
                    min = d;
                    index = i;
                }
            }

        }

        return index;
    }
}