class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int result = 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        while (a >= b) {
            int shift = 1;
            while (a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += (1 << shift - 1);
        }
        if (isNeg) {
            return -result;
        }
        return result;
    }
}
