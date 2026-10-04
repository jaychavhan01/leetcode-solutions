class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k<=1) return 0;
        int diff=Integer.MAX_VALUE;;
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-k;i++) {
            int cdiff = nums[i+k-1]-nums[i];
            if(cdiff<diff) diff=cdiff;
        }
        return diff;
    }
}