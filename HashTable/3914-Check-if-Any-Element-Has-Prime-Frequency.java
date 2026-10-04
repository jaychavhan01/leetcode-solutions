class Solution {
    public boolean checkPrime(int n) {
        if(n==2) return true;
        for(int i=2;i<n;i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        int ar[] = new int[101];
        for(int val:nums) {
            ar[val]++;
        }
        for(int val:ar) {
            if(val>1) {
                boolean res=checkPrime(val);
                if(res) return true;
            }
        }
        return false;
    }
}