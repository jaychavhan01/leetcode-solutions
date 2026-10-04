class Solution {
    public int[] leftRightDifference(int[] nums) {
        int len = nums.length;
        int res[] = new int[len];
        int sum = 0;
        int leftsum = 0;
        for(int i=0;i<len;i++) {
            sum += nums[i];
        }
        for(int i=0;i<len;i++) {
            int rightsum = sum-leftsum-nums[i];
            res[i] = Math.abs(leftsum-rightsum);
            leftsum += nums[i];
        }
        return res;
    }
}