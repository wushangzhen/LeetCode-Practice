class Solution {
public:
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    int sqrt(int x) {
        // write your code here
        if (x == 0) {
            return 0;
        }
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            long long mid = start + (end - start) / 2;
            long long product = mid * mid;
            if (product == x) {
                return mid;
            } else if (product < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        long long product = 1;
        product *= end;
        product *= end;
        //long long product = long long (end * end);
        if (product <= x) {
            return end;
        }
        return start;
    }
};
