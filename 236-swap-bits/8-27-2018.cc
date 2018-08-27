class Solution {
public:
    /*
     * @param x: An integer
     * @return: An integer
     */
    int swapOddEvenBits(int x) {
        // write your code here
        int temp1 = x << 1;
        int temp2 = x >> 1;
        temp2 &= 0x55555555;
        temp1 &= 0xaaaaaaaa;
        return temp1 + temp2;
    }
};
