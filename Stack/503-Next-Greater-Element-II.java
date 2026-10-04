class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int res[] = new int[len];
        for(int i=0;i<len;i++) {
            int ind = i;
			int ans = -1;
            do {
                if(nums[ind]>nums[i]) {
                    ans = nums[ind];
					break;
                }
                ind = (ind+1)%len;
            }while(ind!=i);
			res[i] = ans;
        }
        return res;
    }
}