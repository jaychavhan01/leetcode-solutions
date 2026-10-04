class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        // We only track odd numbers. index i represents (2i + 1)
        // size = n/2 covers all odd numbers up to n
        boolean[] isComposite = new boolean[n / 2];
        int count = 1; // Start at 1 to account for the prime '2'
        
        int limit = (int) Math.sqrt(n);
        for (int i = 1; i < n / 2; i++) {
            if (!isComposite[i]) {
                count++;
                int p = 2 * i + 1;
                // Avoid overflow and only mark if p is small enough to have multiples < n
                if (p <= limit) {
                    // Start marking from p * p
                    // The index for p*p is (p*p - 1) / 2
                    for (int j = 2 * i * (i + 1); j < n / 2; j += p) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        return count;
    }
}