class Solution {
    public int[] resultArray(int[] nums) {
        if(nums.length<2) return nums;
        int len = nums.length;
        int ar1[]=new int[len];
        int ar2[]=new int[len];
        int ind1=0;
        int ind2=0;
        ar1[0]=nums[0];
        ar2[0]=nums[1];
        for(int i=2;i<len;i++) {
            if(ar1[ind1]>ar2[ind2]) {
                ar1[++ind1]=nums[i];
            }
            else {
                ar2[++ind2]=nums[i];
            }
        }
        for(int i=0;i<=ind2;i++) {
            ar1[++ind1]=ar2[i];
        }
        return ar1;
    }
}