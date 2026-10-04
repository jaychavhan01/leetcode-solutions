class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2) return 0;
        int max=0;
        Arrays.sort(nums);
        for(int i=1;i<n;i++) {
            max=Math.max(max,nums[i]-nums[i-1]);
        }
        return max;
    }
}