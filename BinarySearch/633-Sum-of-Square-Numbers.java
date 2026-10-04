class Solution {
    public boolean judgeSquareSum(int c) {
        long a=0;
        long b = (int)Math.sqrt(c);
        while(a<=b) {
            long res = a*a+b*b;
            if(res==c) return true;
            if(res<c) a++;
            else b--;
        }
        return false;
    }
}