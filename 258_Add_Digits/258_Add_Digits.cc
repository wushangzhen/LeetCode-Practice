#include <iostream>

int addDigits(int num) {
  int temp = num;
  int digit = 0;
  int sum = 0;
  while (temp > 0) {
    digit = temp % 10;
    temp = temp / 10;
    sum += digit;
    if (sum > 9 && temp == 0) {
      temp = sum; 
      sum = 0;
    }
  }
  return sum;
}
int main() {
  std::cout << addDigits(3) << std::endl;
}
