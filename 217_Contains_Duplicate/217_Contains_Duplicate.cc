#include <iostream>
#include <unordered_map>
#include <vector>

bool containsDuplicate(std::vector<int> vec) {
  std::unordered_map<int, int> un_map;
  for (int i = 0; i < vec.size(); i++) {
    if (un_map.find(vec[i]) != un_map.end()) {
      return true;
    }
    un_map[vec[i]]++;
  }
  return false;
}
int main() {
  std::vector<int> vec = {1, 2, 2, 3};
  std::cout << containsDuplicate(vec) << std::endl;
}
