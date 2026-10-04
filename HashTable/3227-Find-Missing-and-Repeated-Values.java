class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        int res[] = new int[2];
        int asum = 0;
        int esum = ((n*n)*(n*n+1))/2;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                asum += grid[i][j];
                if(set.contains(grid[i][j])) {
                    res[0]=grid[i][j];
                }
                else {
                    set.add(grid[i][j]);
                }
            }
        }
        res[1] = esum+res[0]-asum;
        return res;
    }
}