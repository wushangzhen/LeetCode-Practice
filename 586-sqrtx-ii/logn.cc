class Solution {
public:
    /**
     * @param x: a double
     * @return: the square root of x
     */
    double sqrt(double x) {
        // write your code here
        double start = 0.0;
        double end = max(x, 1.0);
        while (start + 1e-12 < end) {
            double mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end == x) {
            return end;
        }
        return start;
    }
};
