class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int common = 10;

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    common = Math.min(common, nums1[i]);
                }
            }
        }

        if(common != 10)
            return common;

        int sm1 = nums1[0];
        for(int i = 1; i < nums1.length; i++) {
            if(nums1[i] < sm1)
                sm1 = nums1[i];
        }

        int sm2 = nums2[0];
        for(int i = 1; i < nums2.length; i++) {
            if(nums2[i] < sm2)
                sm2 = nums2[i];
        }

        return Math.min(sm1 * 10 + sm2,
                        sm2 * 10 + sm1);
    }
}