#include <iostream>
using namespace std;

int* test2(int* p, int &b);
void test() {
    int a = 6;
    int *p = &a;
    cout << p << endl;
    int b = 7;
    cout << p << endl;
}
int* test2(int* p, int &b) {
    p = &b;
    return p;
}
int main() {
    test();
}
