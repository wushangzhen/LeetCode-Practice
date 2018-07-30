#include <iostream>
#include <vector>
#include <math.h>
using namespace std;
class Solution {
public:
    /**
     * @param num: An integer
     * @return: an integer array
     */
    vector<int> primeFactorization(int num) {
        // write your code here
        int n = num;
        int up_bound = sqrt(num);
        vector<int> vec_result;
        for (int k = 2; k <= up_bound && n > 1; k++) {
            while (n % k == 0) {
                n /= k;
                vec_result.push_back(k);
            }
        }
        if (n > 1) {
            vec_result.push_back(n);
        }
        return vec_result;
    }
};
int main() {
    int input = 660;
    Solution A;
    vector<int> vec = A.primeFactorization(input);
    vector<int>::iterator iter = vec.begin();
    while (iter != vec.end()) {
        cout << *iter << endl;
        iter++;
    }
}
