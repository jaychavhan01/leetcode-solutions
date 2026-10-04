class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int logN = (int) (Math.log(n)/Math.log(2))+1;
        int[][] max = new int[logN][n];
        int[][] min = new int[logN][n];

        for(int i=0;i<n;i++) {
            max[0][i] = nums[i];
            min[0][i] = nums[i];
        }

        for(int j=1;j<logN;j++) {
            for(int i=0;i+(1<<j)<=n;i++) {
                max[j][i] = Math.max(max[j - 1][i], max[j - 1][i + (1 << (j - 1))]);
                min[j][i] = Math.min(min[j - 1][i], min[j - 1][i + (1 << (j - 1))]);
            }
        }
        int[] logs = new int[n+1];
        for(int i=2;i<=n;i++) {
            logs[i] = logs[i/2]+1;
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(b[0],a[0]));

        for(int i=0;i<n;i++) {
            pq.offer(new long[]{getVal(i,n-1,max,min,logs),i,n-1});
        }
        long totalValue = 0;
        for (int i = 0; i < k; i++) {
            long[] top = pq.poll();
            totalValue += top[0];
            int l = (int) top[1];
            int r = (int) top[2];
            
            if (r > l) {
                pq.offer(new long[]{getVal(l, r - 1, max, min, logs), l, r - 1});
            }
        }
        
        return totalValue;
    }

    private long getVal(int l, int r, int[][] maxST, int[][] minST, int[] logs) {
        int j = logs[r - l + 1];
        int maxVal = Math.max(maxST[j][l], maxST[j][r - (1 << j) + 1]);
        int minVal = Math.min(minST[j][l], minST[j][r - (1 << j) + 1]);
        return (long) maxVal - minVal;
    }
}