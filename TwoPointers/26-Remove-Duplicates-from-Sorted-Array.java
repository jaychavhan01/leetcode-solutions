class Solution {
    public int removeDuplicates(int[] nums) {
        int ind = 0;
        int count = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[ind]!=nums[i]) {
                ind++;
                count++;
                nums[ind] = nums[i];
            }
        }
        return count;
    }
}