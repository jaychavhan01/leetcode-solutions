class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        for(int val:nums) {
            freq[val]++;
        }
        int max=0;
        for(int val:freq) {
            if(val>max) max=val;
        }
        int count=0;
        for(int val:freq) {
            if(val==max) count++;
        }
        return count*max;
    }
}