#include <iostream>
using namespace std;
int main() {
    bool* ptr = new bool[10, true];
    for (int i = 0; i < 10; i++) {
        cout << ptr[i] << endl;
    }
}
