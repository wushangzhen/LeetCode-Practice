class Solution {
public:
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    int divide(int dividend, int divisor) {
        // write your code here
        if (divisor == 0) {
            return dividend >= 0 ? INT_MAX : INT_MIN;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        } 
        if (dividend != INT_MAX && abs(dividend) < abs(divisor)) {
            return 0;
        }
        bool isNegativeDivisor = false;
        bool isNegativeDividend = false;
        int start = 1;
        int end = dividend;
        if (dividend < 0) {
            end = -dividend;
            isNegativeDividend = true;
        }
        if (divisor < 0) {
           divisor = -divisor; 
           isNegativeDivisor = true;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int result = 0;
            for (int i = 0; i < divisor; i++) {
                result += mid;
            }
            if (result < dividend) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int output1 = 0;
        int output2 = 0;
        for (int i = 0; i < divisor; i++) {
            output1 += start;
            output2 += end;
        }
        if (output2 == dividend) {
            if ((isNegativeDivisor && !isNegativeDividend) 
            || (!isNegativeDivisor && isNegativeDividend))
                return -end;
            return end;
        }
        if ((isNegativeDivisor && !isNegativeDividend) 
            || (!isNegativeDivisor && isNegativeDividend))
            return -start;
        return start;
    }
};
