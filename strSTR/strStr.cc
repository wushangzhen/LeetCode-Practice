#include <iostream>
#include <string>
int strStr(std::string source, std::string target) {
  if (source == "" || target == "") {
    return -1;
  }
  for (int i = 0; i < source.length(); i++) {
    if (source[i] != target[0]) {
       continue;
    } else {
      for (int j = 0; j < target.length(); j++) {
        if (source[i+j] != target[j]) {
          break;
        }
        if (j == target.length() - 1) {
          return i;
        }
      }
    }
  }
  return -1;
}
int main() {
  std::string source("mississippi");
  std::string target("sippi");
  std::cout << strStr(source, target) << std::endl;

}
