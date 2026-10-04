class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int ls = 2;
        int sl = 1;
        for(int i = 3;i<=n;i++) {
            int curr = ls+sl;
            sl = ls;
            ls = curr;
        }
        return ls;
    }
}