#include <iostream>

int reverse(int x) {
  long long res = 0;
  bool isPositive = true;
  if (x < 0) {
    x = -x;
    isPositive = false;
  }
  while (x != 0) {
    res = x % 10 + res * 10;
    x = x / 10;
  }
  if (!isPositive) {
    res = -res;
  }
  if (res > INT_MAX || res < INT_MIN) {
    return 0;
  }
  return res;
}
int main() {
  int input1 = -321;
  std::cout << reverse(input1) << std::endl;
}
