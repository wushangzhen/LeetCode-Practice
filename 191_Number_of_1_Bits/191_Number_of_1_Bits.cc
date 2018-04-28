#include <iostream>

int hammingWeight(uint32_t n) {
  uint32_t count = 0;
  for (int i = 0; i < 32; i++) {
      if (n & 1) {
          count++;
      }
      n >>= 1;
  }
  return count;
}

int main() {
  std::cout << hammingWeight(11) << std::endl;
}
