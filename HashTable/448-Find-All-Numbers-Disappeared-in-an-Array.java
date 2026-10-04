class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean ar[] = new boolean[nums.length+1];
        for(int i=0;i<nums.length;i++) {
            //int temp = nums[i];
            ar[nums[i]] = true;
        }
        for(int i=1;i<ar.length;i++) {
            if(!ar[i]) {
                res.add(i);
            }
        }
        return res;
    }
}