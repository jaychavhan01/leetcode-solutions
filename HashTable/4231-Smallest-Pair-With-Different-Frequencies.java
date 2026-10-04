class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int ar[] = new int[101];
        for(int val:nums) {
            ar[val]++;
        }
        int freq=-1;
        for(int i=1;i<ar.length;i++) {
            if(ar[i]==0) continue;
            int freq1 = ar[i];

            for (int j = i + 1; j <= 100; j++) {
                if (ar[j] != 0 && ar[j] != freq1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}