#include <iostream>

int test() {
  int i = 0;
  int temp = 0;
  i++;
  if (i == 10) {
    return 1; 
  }
  temp = test();
  std::cout << "temp: " << temp << std::endl;
  return i;
} 
int main() {
  std::cout << test() << std::endl;
}
