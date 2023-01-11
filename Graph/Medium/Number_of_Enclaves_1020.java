package DSApractice.Graph.Medium;

public class Number_of_Enclaves_1020 {

    private boolean flag = true;
    public int numEnclaves(int[][] grid) {
        int count = 0;  // will keep track of number of islands

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int x = DFS(grid, i, j);
                    if (flag) {
                        count += x;
                    }
                    flag = true;
                }
            }
        }

        return count;
    }

    private int DFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            if (grid[i][j] == 1) {
                flag = false;
            }
        }

        grid[i][j] = 0;
        return 1 + DFS(grid, i + 1, j) +
                DFS(grid, i - 1, j) +
                DFS(grid, i, j + 1) +
                DFS(grid, i, j - 1);
    }
}