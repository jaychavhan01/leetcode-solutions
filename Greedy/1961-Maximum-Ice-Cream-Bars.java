class Solution {
    public int maxIceCream(int[] costs, int coins) {
        if(coins==0) return 0;
        Arrays.sort(costs);
        int count=0;
        for(int val : costs) {
            if(val>coins) {
                break;
            }
            count++;
            coins -= val;
        }
        return count;
    }
}