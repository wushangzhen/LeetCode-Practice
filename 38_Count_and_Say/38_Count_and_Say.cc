#include <iostream>
#include <string>

std::string countAndSay(int n) {
  std::string temp = std::to_string(1);
  std::string result = "1";
  int count = 1;
  int i = n;
  while (i > 1) {
    result = "";
    for (int j = 0; j != temp.length(); j++) {
      while (temp[j] == temp[j + 1] && (j + 1) != temp.length()) {
        count++;
        j++;
      }
      result += std::to_string(count);
      result += temp[j]; 
      count = 1;
    } 
    temp = result;
    i--;
  }
  return result;
}

int main() {
  std::cout << countAndSay(1) << std::endl;
  std::cout << countAndSay(2) << std::endl;
  std::cout << countAndSay(3) << std::endl;
  std::cout << countAndSay(4) << std::endl;
  std::cout << countAndSay(5) << std::endl;
}
