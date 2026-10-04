class Solution {
    public int arrangeCoins(int n) {
        int i =1;
        long sum=0;
        //if(n==1) return 1;
        while(true) {
            if(sum==n) return i-1;
            else if(sum>n) return i-2;
            sum = sum+i;
            i++;
        }
    }
}