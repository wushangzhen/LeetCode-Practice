class Solution {
public:
    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    int gcd(int a, int b) {
        // write your code here
        int small = 0;
        int big = 0;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        if (small != 0) {
            return gcd(small, big % small);
        } else {
            return big;
        }
    } 
};
