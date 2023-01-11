package DSApractice.Graph.Medium;

public class Max_Area_of_Island_695 {

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, DFS(grid, i, j));
                }
            }
        }

        return area;
    }

    private int DFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 0;
        return 1 + DFS(grid, i + 1, j) +
                DFS(grid, i - 1, j) +
                DFS(grid, i, j + 1) +
                DFS(grid, i, j - 1);
    }
}