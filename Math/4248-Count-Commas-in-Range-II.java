class Solution {
    public long countCommas(long n) {
        long count = 0;
        long start = 1000;
        int commas = 1;

        while (start <= n) {
            long end = start * 1000 - 1;

            count += (Math.min(n, end) - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return count;
    }
}