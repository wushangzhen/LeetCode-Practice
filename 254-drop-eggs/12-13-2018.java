public class Solution {
    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        // write your code here
        long index = 1;
        long N = n;
        while ((index + 1) * index < N * 2) {
            index *= 2;
        }
        long start = 0;
        long end = index;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if ((mid + 1) * mid < N * 2) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if ((start + 1) * start >= N * 2) {
            return (int) start;
        }
        return (int) end;
    }
}
