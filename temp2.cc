#include <unordered_set>
using namespace std;
int* findCommon(int arr1[], int arr2[], int n, int& outArrSize) {
    int* p = new int[n];
    unordered_set<int> hash1;
    unordered_set<int> hash2;
    for (int i = 0; i < n; i++) {
        hash1.insert(arr1[i]);
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (hash1.find(arr2[i]) != hash1.end() && hash2.find(arr2[i]) == hash2.end()) {
            *(p + count) = arr2[i];
            hash2.insert(arr2[i]);
            count++;
        }
    }
    outArrSize = count;
    return p;
}
int main() {
    int arr1[6] = {3, 1, 3, 2, 6, 4};
    int arr2[6] = {3, 1, 3, 2, 6, 4};
    int x = 0;
    int *ptr = findCommon(arr1, arr2, 6, &x);
    for (int i = 0; i < 6; i++) {
        cout << *(ptr + i) << endl;
    }
}
