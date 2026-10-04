class Solution {
    public long sumAndMultiply(int n) {
        long temp=n;
        long rev=0;
        int sum=0;
        while(temp>0) {
            long ld = temp%10;
            if(ld!=0) {
                rev = rev*10 +ld;
                sum += ld;
            }
            temp /= 10;
        }
        temp=0;
        while(rev>0) {
            temp = temp*10 + rev%10;
            rev /=10;
        }
        return temp*sum;
    }
}