package DSApractice.Arrays.Easy;

public class Check_If_It_Is_a_Straight_Line_1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int x2 = coordinates[1][0], y2 = coordinates[1][1];
        int dx = x2 - x1, dy = y2 - y1;

        for (int[] c : coordinates) {
            if (dx * (c[1] - y2) != dy * (c[0] - x2)) {
                return false;
            }
        }

        return true;
    }
}