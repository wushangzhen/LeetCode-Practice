#include <iostream>
int strStr(string source, string target) {
  if (!source || !target) {
    return -1;
  }
  int temp = 0;
  for (int i = 0; i < source.length(); i++) {
    if (source[i] == target[0]) {
      for (int j = i, k = 1; j < i + target.length(), k < target.length(); j++) {
        if (source[j] == target[k]) {
          continue;
        }
        else {
          return -1
        }
      }
    }
    return -1;
    return i;
  }
}
int main() {
  string source("str");
  string target("t");
  std::cout << strStr(source, target) << std::endl;

}
