class Solution {
    public int findLucky(int[] arr) {
        int freq[] = new int[501];
        for(int val:arr) {
            freq[val]++;
        }
        int max=-1;
        for(int i=1;i<freq.length;i++) {
            if(freq[i]==i && freq[i]>max) {
                max=i;
            }
        }
        return max;
    }
}