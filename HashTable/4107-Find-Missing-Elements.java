class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int max=nums[0];
        int min=nums[0];
        for(int num:nums) {
            if(num>max) max=num;
            if(num<min) min=num;
        }
        Set<Integer> ele = new HashSet<>();
        for(int num:nums) {
            ele.add(num);
        }
        for(int i=min+1;i<max;i++) {
            if(!ele.contains(i)) res.add(i);
        }
        return res;
    }
}