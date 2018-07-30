#include <iostream>
#include <vector>
using namespace std;
void insertionSort(vector<int>& vec) {
    int len = vec.size();
    if (len == 0) {
        return;
    }
    for (int i = 1; i < len; i++) {
        int t = vec[i];
        int index = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (vec[j] > t) {
                vec[j + 1] = vec[j];
            } else {
                index = j + 1;
                break;
            }
        }
        vec[index] = t;
    }
}

int main() {
    int a[5] = {2, 5, 1, 3, 4};
    vector<int> vec(a, a + 5);
    insertionSort(vec);
    for (vector<int>::iterator iter = vec.begin(); iter != vec.end(); iter++) {
        cout << *iter << endl;
    }
} 
