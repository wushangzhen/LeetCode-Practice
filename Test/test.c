#include <stdio.h>
float f;
float f2(float a) {
    f = a * a;
    return f;
}
int main() {
    printf("%f", f2(5.0));
}
