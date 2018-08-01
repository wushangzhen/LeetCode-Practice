#include <iostream>
#include <math.h>
using namespace std;
class Solution {
public:
    int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        if (n % 2 == 0) {
            long tmp = fastPower(a, b, n / 2);
            tmp = (tmp * tmp) % b;
            return (int) tmp;
        }
        if (n % 2 == 1) {
            long tmp = fastPower(a, b, n / 2);
            tmp = ((tmp * tmp) % b * a) % b; // this is the key point.
            // tmp * tmp * a will overflow
            // we have to %b twice to avoid that.
            return (int) tmp;
        }
        //long product = fastPower(a, b, n / 2);
        //product = (product * product) % b;
        //if (n % 2 == 1) {
        //    product = (product * a) % b;
        //}
        //return (int) product;
    }
};
int main() {
    Solution s;
    cout << s.fastPower(2147483647, 2147483645,214748364) << endl;
    cout << pow(2.0, 2147483647) << endl;
}
