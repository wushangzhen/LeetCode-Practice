public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            return -1;
        }
        double start;
        double end;
        if (x < 1) {
            start = 0;
            end = 1;
        } else {
            start = 1;
            end = x;
        }
        double eps = 1e-12;
        while (start + eps < end) {
            double mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return end;
        } else {
            return start;
        }
    }
}
