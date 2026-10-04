class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                pivot=i;
                break;
            }
        }
        if(pivot==-1) {
            int st=0;
            int end = n-1;
            while(st<end) {
                int temp = nums[st];
                nums[st] = nums[end];
                nums[end] = temp;
                st++;
                end--;
            }
            return;
        }
        for(int i=n-1;i>pivot;i--) {
           if(nums[i]>nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }
        int i=pivot+1;
        int j=n-1;
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}