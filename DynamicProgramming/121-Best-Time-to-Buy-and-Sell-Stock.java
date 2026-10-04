class Solution {
    public int maxProfit(int[] prices) {
        int buystock = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0;i<prices.length;i++) {
            if(buystock < prices[i]) {
                int profit = prices[i] - buystock;

                maxprofit = Math.max(maxprofit,profit);
            }
            else {
                
                buystock = prices[i];
            }
        }
        return maxprofit;
        
    }
}