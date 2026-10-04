class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int ar[] = new int[nums.length];
        if(nums.length==1) return nums;
        int eind = 0;
        int oind=nums.length-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]%2==0) {
                ar[eind]=nums[i];
                eind++;
            }
            else {
                ar[oind]=nums[i];
                oind--;
            }
        }
        return ar;
    }
}