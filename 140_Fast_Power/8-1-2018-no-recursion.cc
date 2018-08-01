#include <iostream>
using namespace std;
int power(int x, int n) {
    int ans = 1, base = x;
    while (n != 0) {
        cout << "n = " << n << endl; 
        cout << "base = " << base << endl; 
        cout << "ans = " << ans << endl; 
        cout << "------------------" << endl;
        if (n % 2 == 1) {
            ans *= base;
        }
        base *= base;
        n /= 2;
    }
    return ans;
}

int fastPower(int a, int b, int n) {
        // write your code here
        long ans = 1, tmp = a;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * tmp) % b;
            }
            tmp = (tmp * tmp) % b;
            n /= 2;
        }
        return (int) ans % b; // for the case n = 0, it will not go to while loop
}

int main() {
   cout << power(2, 5) << endl; 
}
