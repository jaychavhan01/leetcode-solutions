class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int leftsum[] = new int[len];
        int rightsum[] = new int[len];
        int sum=0;
        for(int i=0;i<len;i++) {
            leftsum[i]= sum;
            sum += nums[i];
        }
        sum=0;
        for(int i=(len-1);i>=0;i--) {
            rightsum[i] = sum;
            sum += nums[i];
        }
        for(int i=0;i<len;i++) {
            if(leftsum[i]==rightsum[i]) return i;
        }
        return -1;

    }
}