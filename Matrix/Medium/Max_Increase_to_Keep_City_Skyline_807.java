package DSApractice.Matrix.Medium;

public class Max_Increase_to_Keep_City_Skyline_807 {

    /*
    * we find the max element in each row and column
    * now for every element we replace the element with min(max of that row, max of that col)
    */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length], col = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }


        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int min = Math.min(row[i], col[j]);
                count = count + (min - grid[i][j]);
            }
        }

        return count;
    }
}