class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        boolean seen[] = new boolean[len+1];
        int dup = -1,miss = -1;
        for(int num:nums) {
            if(seen[num]) {
                dup = num;
            }
            else {
                seen[num]=true;
            }
        }
        for (int i = 1; i <= len; i++) {
            if (!seen[i]) {
                miss = i;
                break;
            }
        }

        return new int[]{dup, miss};
    }
}