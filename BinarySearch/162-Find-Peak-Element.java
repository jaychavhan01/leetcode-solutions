class Solution {
    public int findPeakElement(int[] nums) {
        int i=1;
        while(i<nums.length && nums[i]>nums[i-1]) {
            i++;
        }
        return i-1;
    }
}