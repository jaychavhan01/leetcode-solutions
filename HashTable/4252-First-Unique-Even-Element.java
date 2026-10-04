class Solution {
    public int firstUniqueEven(int[] nums) {
        int ar[] = new int[101];
        for(int i=0;i<nums.length;i++) {
            ar[nums[i]]++;
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]%2==0 && ar[nums[i]]==1)
                return nums[i]; 
        }
        return -1;
    }
}