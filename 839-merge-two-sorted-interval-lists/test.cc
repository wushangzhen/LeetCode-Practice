#include <iostream>
#include <vector>
using namespace std;
int main() {
    vector<int> vec;
    vec.push_back(1);
    vec.insert(vec.begin() + 1, 2);
    auto it = vec.begin();
}
