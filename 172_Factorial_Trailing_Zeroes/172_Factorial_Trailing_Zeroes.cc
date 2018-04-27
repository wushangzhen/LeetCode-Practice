#include <iostream>

//int trailingZeroes(int n) {
//        long long temp = 1;
//        int res = 0;
//        for (int i = n; i > 0; i--) {
//            temp *= i;
//        }
//        std::cout << temp << std::endl;
//        while (temp % 10 == 0) {
//            res++;
//            temp /= 10;
//        }
//        return res;
//    }
//
int trailingZeroes(int n) {
  long long i = 5;
  int res = 0;
  while (i <= n) {
    res += n / i;
    i *= 5;
  }
  return res;
} 
int main() {
  std::cout << trailingZeroes(4617) << std::endl;
}
