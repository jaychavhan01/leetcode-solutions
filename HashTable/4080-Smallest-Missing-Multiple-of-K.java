class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int val:nums) {
            set.add(val);
        }
        int st=1;
        while(set.contains(st*k)) {
            st++;
        }
        return st*k;
    }
}