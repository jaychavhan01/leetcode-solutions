class Solution {
    public int reverse(int x) {
        int num = 0;
        int temp = x;

        if (x < 0) {

            if (x == Integer.MIN_VALUE) return 0;
            x = -1 * x;
        }

        while (x > 0) {
            int digit = x % 10;

            if (num > Integer.MAX_VALUE / 10 ||
               (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            num = (num * 10) + digit;
            x /= 10;
        }

        if (temp > 0) return num;

        if (num > Integer.MAX_VALUE) return 0;

        return -1 * num;
    }
}