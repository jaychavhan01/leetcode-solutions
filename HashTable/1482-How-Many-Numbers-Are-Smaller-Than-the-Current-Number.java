class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int ar[] = new int[nums.length];
        for(int i =0;i<nums.length;i++) {
            int sum = 0;
            for(int j = 0;j<nums.length;j++) {
                if(i!=j&&nums[i]>nums[j]) {
                    sum++;
                }
            }
            ar[i] = sum;
        }
        return ar;
    }
}