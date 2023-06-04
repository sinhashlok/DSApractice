package DSApractice.Graph.Medium;

public class Number_of_Closed_Islands_1254 {

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    if (grid[i][j] == 0) {
                        DFS(grid, i, j);
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[i].length; ++j) {
                if (grid[i][j] == 0) {
                    DFS(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void DFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 0) {
            return;
        }

        grid[i][j] = 1;
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }
}