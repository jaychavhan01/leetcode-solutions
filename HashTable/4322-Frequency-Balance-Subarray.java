class Solution {
    public int getLength(int[] nums) {

        int[] dremovical = nums;

        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            HashMap<Integer, Integer> freqCnt = new HashMap<>();

            int maxFreq = 0;
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int x = nums[j];

                int oldFreq = freq.getOrDefault(x, 0);
                int newFreq = oldFreq + 1;

                freq.put(x, newFreq);

                if (oldFreq > 0) {
                    int c = freqCnt.get(oldFreq);
                    if (c == 1) freqCnt.remove(oldFreq);
                    else freqCnt.put(oldFreq, c - 1);
                } else {
                    distinct++;
                }

                freqCnt.put(newFreq,
                        freqCnt.getOrDefault(newFreq, 0) + 1);

                maxFreq = Math.max(maxFreq, newFreq);

                int len = j - i + 1;

                if (len == 1) {
                    ans = Math.max(ans, 1);
                    continue;
                }

                if (distinct == 1) {
                    ans = Math.max(ans, len);
                    continue;
                }

                if ((maxFreq & 1) == 1) continue;

                int half = maxFreq / 2;

                int cntMax = freqCnt.getOrDefault(maxFreq, 0);
                int cntHalf = freqCnt.getOrDefault(half, 0);

                if (cntHalf > 0 && cntMax + cntHalf == distinct) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}