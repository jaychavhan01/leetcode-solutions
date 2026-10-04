class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ar[] = new int[2*n];
        for(int i = 0,j=0;i<n;i++) {
            ar[j] = nums[i];
            j++;
            ar[j] = nums[i+n];
            j++;  
        }
        return ar;
    }
}