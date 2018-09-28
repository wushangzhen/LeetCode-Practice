int* firstPosIntsArr(int n, int& arrSize) {
    arrSize = n;
    int* p = new int[n];
    for (int i = 0; i < n; i++) {
        *(p + i) = i + 1;
    }
    return p;
}
int main() {

}
