class Solution {
    public int largestAltitude(int[] gain) {
        // int ar[] = new int[gain.length+1];
        // ar[0]=0;
        int max=0;
        int sum=0;
        for(int i=0;i<gain.length;i++) {
            sum += gain[i];
            //ar[i+1]=sum;
            max=Math.max(max,sum);
        }
        return max;
    }
}