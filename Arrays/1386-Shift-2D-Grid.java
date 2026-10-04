class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int tot = m*n;
        k = k%tot;

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++) {
                row.add(0);
            }
            res.add(row);
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int oind = i*n+j;
                int nind = (oind+k)%tot;
                int nrow = nind/n;
                int ncol = nind%n;
                res.get(nrow).set(ncol,grid[i][j]);
            }
        }
        return res;
    }
}