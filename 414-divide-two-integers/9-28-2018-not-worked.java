public class Solution {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        final int MAX = Integer.MAX_VALUE;
        if (divisor == 0) {
            return MAX;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        boolean isNeg = false;
        if (dividend < 0 && divisor > 0) {
            isNeg = true;
        }
        if (dividend > 0 && divisor < 0) {
            isNeg = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (divisor > dividend) {
            return 0;
        }
        int start = 1;
        int end = dividend;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            long sum = 0;
            for (int i = 0; i < mid; i++) {
                sum += divisor;
            }
            if (sum == dividend) {
                if (isNeg) {
                    return 0 - mid;
                } else {
                    return mid;
                }
            } else if (sum < dividend) {
                start = mid;
            } else {
                end = mid;
            }
        }
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += divisor;
        }
        if (sum <= dividend) {
            if (isNeg) {
                return 0 - end;
            }
            return end;
        } else {
            if (isNeg) {
                return 0 - start;
            }
            return start;
        }
    }
}
