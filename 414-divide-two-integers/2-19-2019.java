class Solution {
    public int divide(int dividend, int divisor) {
        long dd = dividend;
        long dr = divisor;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        int sign = 1;
        if ((dd < 0 && dr > 0) || (dd > 0 && dr < 0)) {
            sign = -1;
        }
        long res = 0;
        if (dd < 0) {
            dd = -dd;
        }
        if (dr < 0) {
            dr = -dr;
        }
        while (dd >= dr) {
            int flag = 0;
            while (dd >= (dr << flag)) {
                flag++;
            }
            res += (1 << (flag - 1));
            dd -= (dr << (flag - 1));
        }
        res *= sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}
