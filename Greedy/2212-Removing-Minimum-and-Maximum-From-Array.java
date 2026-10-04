class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int min=0;
        int max=0;
        for(int i=1;i<n;i++) {
            if(nums[i]<nums[min])
                min=i;
            if(nums[i]>nums[max])
                max=i;
        }
        int left = Math.min(min,max);
        int right = Math.max(min,max);

        int front = right+1;
        int back = n-left;
        int frbc = (left+1)+(n-right);

        return Math.min(front,Math.min(back,frbc));
    }
}