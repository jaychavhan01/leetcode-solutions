class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum,max=0;
        for(int i = 0;i<accounts.length;i++) {
            sum = 0;
            for(int j = 0;j<accounts[0].length;j++) {
                sum += accounts[i][j];
            }
            if(sum>max) {
                max = sum;
            }
        }
        return max;
    }
}