#include <iostream>
class Solution {
public:
    int mySqrt(int x) {
      if (x < 2) {
          return x;
      }
      for (long long i = 0; i < x; i++) {
        if (i * i <= x && (i+1) * (i+1) > x) {
              return i;       
        }       
      }
    }
};


int mySqrt2(int x) {
  long long a = 0;
  long long b = x / 2 + 1;
  long long mid = (a + b) / 2;
  while (a <= b) {
    if (mid * mid > x) {
      b = mid - 1;
      mid = (a + b) / 2;
    } else if (mid * mid == x) {
      return mid;
    } else {
      a = mid + 1;
      mid = (a + b) / 2;
    }
  }
  return b;
}

int main() {
  int n = 5;
  std::cout << mySqrt2(n) << std::endl;
}
