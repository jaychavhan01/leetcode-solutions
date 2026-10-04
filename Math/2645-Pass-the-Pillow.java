class Solution {
    public int passThePillow(int n, int time) {
        int i=1,d=1;
        while(time>0) {
           if(i==n) {
            d=-1;
           }
           else if(i==1) {
            d=1;
           }
           i = i+d;
           time--;
        }
        return i;
    }
}