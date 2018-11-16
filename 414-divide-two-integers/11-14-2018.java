class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNeg = true;
        }
        long a = Math.abs(Long.valueOf(dividend));
        long b = Math.abs(Long.valueOf(divisor));
        int result = 0;
        while (a >= b) {
            int flag = 0;
            while ((a - (b << flag)) >= 0) {
                flag++;
            }
            a -= b << (flag - 1);
            result += (1 << (flag - 1));
        }
        if (isNeg) {
            return -result;
        }
        return result;
    }
}
