class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            int ele = -1;
            for(int j=0;j<nums2.length;j++) {
                boolean flag = false;
                if(nums1[i]==nums2[j]) {
                    for(int k = j+1;k<nums2.length;k++) {
                        if(nums2[k]>nums1[i]) {
                            ele = nums2[k];
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
            }
            res[i] = ele;
        }
        return res;
    }
}