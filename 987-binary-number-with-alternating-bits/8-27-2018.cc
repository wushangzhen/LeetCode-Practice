class Solution {
public:
    /**
     * @param n: a postive Integer
     * @return: if two adjacent bits will always have different values
     */
    bool hasAlternatingBits(int n) {
        // Write your code here
        return ((n & 0x55555555) == 0) || ((n & 0xaaaaaaaa) == 0);
    }
};
