class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len=nums.length;
        int res[] = new int[len];
        int st = 0;
        int count=0;
        int grtcount = 0;
        for(int i=0;i<len;i++) {
            if(nums[i]<pivot) {
                res[st] = nums[i];
                st++; 
            }
            else if(nums[i]==pivot)
                count++;
        }
        for(int i=1;i<=count;i++) {
            res[st++] = pivot;
        }
         for(int i=0;i<len;i++) {
            if(nums[i]>pivot) {
                res[st++] = nums[i];
            }
        }
        return res;
    }
}