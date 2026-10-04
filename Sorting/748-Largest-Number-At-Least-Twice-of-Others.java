class Solution {
    public int dominantIndex(int[] nums) {
        int lar = Integer.MIN_VALUE;
        int ind = 0;
        int slar = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(lar<nums[i]) {
                slar = lar;
                lar = nums[i];
                ind=i;
            }
            else if(slar<nums[i]) {
                slar = nums[i];
            }
        }
        if(lar>=2*slar) return ind;
        return -1;
    }
}