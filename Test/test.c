#include <stdio.h>
int main() {
    int a[] = {1, 2, 3};
    int* p = a;
    int* q = p;
    p++;
    printf("%ld\n", p);
    printf("%ld\n", q);
}
