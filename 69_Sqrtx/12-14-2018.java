class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long X = x;
        long start = 0;
        long end = X / 2;
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return (int)(end);
        } 
        return (int)(start);
    }
}
