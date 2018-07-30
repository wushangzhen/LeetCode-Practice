#include <iostream>

int tailRecursionExample(int a, int n) {
    // intialize a = 1;
    if (n < 0) {
        return -1;
    }
    if (n == 0) {
        return 1;
    }
    if (n == 1) {
        return a;
    }
    return tailRecursionExample(n * a, n - 1);
}
// This format is tail recursion and it will achieve O(1) room 
// 在递归展开后该函数不再做任何操作，这意味着该函数可以不等子函数执行完，自己直接销毁，这样就不再占用内存。一个递归深度
//O(n)的尾递归函数，可以做到只占用O(1)空间。这极大的优化了栈空间的利用。
