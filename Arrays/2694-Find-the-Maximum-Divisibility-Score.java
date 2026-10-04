class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<divisors.length;i++) {
            int count=0;
            for(int j=0;j<nums.length;j++) {
                if(nums[j]%divisors[i]==0) {
                    count++;
                }
            }
            if(count > max) {
                max = count;
                min = divisors[i];
            } else if (count == max) {
                min = Math.min(min, divisors[i]);
            }
        }
        return min;
    }
}