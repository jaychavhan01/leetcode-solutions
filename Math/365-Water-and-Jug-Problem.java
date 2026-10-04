class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y<target) return false;
        while(y!=0) {
            int temp=y;
            y=x%y;
            x=temp;
        }
        return target%x==0;
    }
}