class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                if(nums1[i]==nums2[j]&&(!ar.contains(nums1[i]))) {
                    ar.add(nums1[i]);
                }
            }
        }
        int res[] = new int[ar.size()];
        for(int i=0;i<ar.size();i++) {
            res[i] = ar.get(i);
        }
        return res;
    }
}