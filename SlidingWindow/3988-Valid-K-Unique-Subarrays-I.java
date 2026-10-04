class Solution {
    int uniqueCount = 0;
    int oddCount = 0;
    int[] freq = new int[100005];

    private void add(int val) {
        if (freq[val] == 0) {
            uniqueCount++;
        }
        
        if (freq[val] % 2 == 0) {
            oddCount++;
        } else {
            oddCount--;
        }
        freq[val]++;
    }

    private void remove(int val) {
        if (freq[val] % 2 == 0) {
            oddCount++;
        } else {
            oddCount--;
        }
        freq[val]--;
        
        if (freq[val] == 0) {
            uniqueCount--;
        }
    }

    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int q = queries.length;
        int n = nums.length;

        int[][] Q = new int[q][3];
        for (int i = 0; i < q; i++) {
            Q[i][0] = queries[i][0];
            Q[i][1] = queries[i][1];
            Q[i][2] = i;
        }

        int blockSize = (int) Math.max(1, Math.sqrt(n));
        Arrays.sort(Q, (a, b) -> {
            int blockA = a[0] / blockSize;
            int blockB = b[0] / blockSize;
            if (blockA != blockB) {
                return Integer.compare(blockA, blockB);
            }

            return (blockA % 2 == 1) ? Integer.compare(b[1], a[1]) : Integer.compare(a[1], b[1]);
        });

        boolean[] ans = new boolean[q];
        int currL = 0, currR = -1;
        
        for (int i = 0; i < q; i++) {
            int L = Q[i][0];
            int R = Q[i][1];
            int id = Q[i][2];

            while (currL > L) {
                currL--;
                add(nums[currL]);
            }
            while (currR < R) {
                currR++;
                add(nums[currR]);
            }
            while (currL < L) {
                remove(nums[currL]);
                currL++;
            }
            while (currR > R) {
                remove(nums[currR]);
                currR--;
            }

            ans[id] = (uniqueCount == k) && (oddCount == 0);
        }

        return ans;
    }
}