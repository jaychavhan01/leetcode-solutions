class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int mul = 1;
        int temp=n;
        while(temp>0) {
            mul *= temp%10;
            sum += temp%10;
            temp/=10;
        }
        return n%(sum+mul)==0;
    }
}