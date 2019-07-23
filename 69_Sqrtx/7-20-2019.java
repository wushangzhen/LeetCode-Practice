class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        // long type is necessary
        long X = (long) x;
        long right = x / 2;
        long left = 1;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (mid * mid == X) {
                return (int)mid;
            } else if (mid * mid > X) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right * right <= X) {
            return (int)right;
        }
        return (int)left;
    }
}
