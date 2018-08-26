class Solution {
public:
    /**
     * @param n: An integer
     * @param m: An integer
     * @param i: A bit position
     * @param j: A bit position
     * @return: An integer
     */
    int updateBits(int n, int m, int i, int j) {
        // write your code here
        long long temp = ~0;
        temp <<= j - i + 1; 
        temp = ~temp;
        temp <<= i;
        temp = ~temp;
        n &= temp;
        n |= (m << i);
        return n;
    
    }
};
