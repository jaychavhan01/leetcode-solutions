class Solution {
    private Boolean[][][] memo;
    private int m, n;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        int maxOpen = (m + n) / 2;
        memo = new Boolean[m][n][maxOpen + 1];
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int open) {
        if (grid[r][c] == '(') {
            open++;
        } else {
            open--;
        }
        if (open < 0 || open > (m + n) / 2) {
            return false;
        }
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }
        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }
        boolean foundPath = false;
        if (r + 1 < m) {
            foundPath = dfs(grid, r + 1, c, open);
        }
        if (!foundPath && c + 1 < n) {
            foundPath = dfs(grid, r, c + 1, open);
        }
        return memo[r][c][open] = foundPath;
    }
}