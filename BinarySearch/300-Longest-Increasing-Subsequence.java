class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int ar[] = new int[len];
        Arrays.fill(ar,1);
        int res = 1;
        for(int i=1;i<len;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    ar[i] = Math.max(ar[i],ar[j]+1);
                }
            res = Math.max(res,ar[i]);
            }
        }
        return res;
    }
}