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
        long dd = dividend;
        long dr = divisor;
        if ((dd > 0 && dr < 0) || (dd < 0 && dr > 0)) {
            isNeg = true;
        }
        long result = 0;
        dd = Math.abs(dd);
        dr = Math.abs(dr);
        while (dd >= dr) {
            int flag = 0;
            while (dd - (dr << flag) >= 0) {
                flag++;
            }
            result += (1 << (flag - 1));
            dd -= (dr << (flag - 1));
        }
        if (isNeg) {
            return (int)(-result);
        }
        return (int)result;
    }
}
