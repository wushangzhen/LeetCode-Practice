class Solution {
public:
    /**
     * @param n: a number
     * @param d: digit needed to be rorated
     * @return: a number
     */
    int leftRotate(int n, int d) {
        // write code here
        for (int i = 0; i < d; i++) {
            int temp = n & 0x80000000;
            n <<= 1;
            if (temp != 0) {
                n++;
            }
        }
        return n;
    }
};
