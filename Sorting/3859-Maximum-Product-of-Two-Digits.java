class Solution {
    public int maxProduct(int n) {
        int max = 0;
        int max2 = 0;
        while(n>0) {
            int dig = n%10;
            if(dig>max) {
                max2 = max;
                max = dig;
            }
            else if(dig>max2) {
                max2 = dig;
            }
            n/=10;
        }
        return max*max2;
    }
}