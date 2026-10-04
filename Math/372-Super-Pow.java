class Solution {
    public int superPow(int a, int[] b) {
        int res = 1;
        a %= 1337;
        for(int i=0;i<b.length;i++) {
            res = power(res,10)*power(a,b[i])%1337;
        }
        return res;
    }
    int power(int base,int exp) {
        int res = 1;
        exp %= 1337;
        for(int i=1;i<=exp;i++) {
            res = (res*base)%1337;
        }
        return res;
    }
}