#include <iostream>
using namespace std;
void func(int* p, int i) {
    if (i == 1) {
        return;
    }
    cout << p << endl;
    i--;
    func(p, i);
}

int main() {
    int k = 5;
    int *p = &k;
    cout << p << endl;
    cout << endl;
    func(p, k);
}
