class Solution {
    public int[] transformArray(int[] nums) {
        int evenCount=0;
        for(int i=0;i<nums.length;i++) 
            if(nums[i]%2==0) evenCount++;
        for(int i=0;i<evenCount;i++) nums[i]=0;
        for(int i=evenCount;i<nums.length;i++) nums[i]=1;
        return nums;
    }
}