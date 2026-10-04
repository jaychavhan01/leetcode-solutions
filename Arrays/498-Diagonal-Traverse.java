class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int ind = 0;

        for (int d = 0; d < m + n - 1; d++) {

            // EVEN diagonal -> upward
            if (d % 2 == 0) {

                int r = Math.min(d, m - 1);
                int c = d - r;

                while (r >= 0 && c < n) {
                    ans[ind++] = mat[r][c];
                    r--;
                    c++;
                }
            }

            // ODD diagonal -> downward
            else {

                int c = Math.min(d, n - 1);
                int r = d - c;

                while (c >= 0 && r < m) {
                    ans[ind++] = mat[r][c];
                    r++;
                    c--;
                }
            }
        }

        return ans;
    }
}