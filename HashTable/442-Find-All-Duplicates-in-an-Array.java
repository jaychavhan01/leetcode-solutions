class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(!(set.add(nums[i]))) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}