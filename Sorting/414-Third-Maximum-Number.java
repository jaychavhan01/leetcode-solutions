class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            long num = nums[i];

            // skip duplicates
            if(num == max || num == max2 || num == max3) continue;

            if(num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            }
            else if(num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if(num > max3) {
                max3 = num;
            }
        }

        if(max3 == Long.MIN_VALUE) return (int)max;

        return (int)max3;
    }
}