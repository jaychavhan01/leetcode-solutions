class Solution {
    public int[] constructRectangle(int area) {
        int ar[] = new int[2];
        int sqrt = (int)Math.sqrt(area);
        if(sqrt*sqrt==area) {
            ar[0]=sqrt;
            ar[1]=sqrt;
            return ar;
        }
        while(area%sqrt!=0) {
            sqrt--;
        }
        ar[0]=area/sqrt;
        ar[1]=sqrt;
        return ar;
    }
}