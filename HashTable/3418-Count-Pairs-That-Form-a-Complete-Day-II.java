class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long count = 0;
        int[] freq = new int[24];

        for (int h : hours) {
            int rem = h % 24;
            int complement = (24 - rem) % 24;

            count += freq[complement];
            freq[rem]++;
        }

        return count;
    }
}