class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];

        if(nums.length!=max+1) return false;
        for(int i=0;i<max;i++) {
            if(i+1!=nums[i]) return false;
        }
        return true;
    }
}