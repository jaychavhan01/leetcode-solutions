class Solution {
    public int xorOperation(int n, int st) {
        int res=st;
        for(int i = 1;i<n;i++) {
            res ^= st+2*i;
            //st= st +2;
        }
        return res;
    }
}