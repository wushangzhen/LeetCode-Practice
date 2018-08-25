class Solution {
public:
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    int nthUglyNumber(int n) {
        // write your code here
        vector<int> results;
        results.push_back(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int lastNumber = results[i - 1];
            while (results[p2] * 2 <= lastNumber) {
                p2++;
            }
            while (results[p3] * 3 <= lastNumber) {
                p3++;
            }
            while (results[p5] * 5 <= lastNumber) {
                p5++;
            }
            int min = results[p2] * 2;
            min = min > results[p3] * 3 ? results[p3] * 3 : min;
            min = min > results[p5] * 5 ? results[p5] * 5 : min;
            results.push_back(min);
        }
        return results[n - 1];
    }
};
