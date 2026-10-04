class Solution {
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int sum = 0;
            int temp = nums[i];
            while(temp>0) {
                sum += temp%10;
                temp /= 10;
            }
            nums[i] = sum;
        }
        int min = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<min)
                min = nums[i];
        }
        return min;
    }
}