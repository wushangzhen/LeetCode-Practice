#include <iostream> 
#include <vector>
#include <unordered_map>

bool constainDuplicate(std::vector<int> vec, int k) {
  std::unordered_map<int, int> un_map;
  for (int i = 0; i < vec.size(); i++) {
    if (un_map.find(vec[i]) != un_map.end() && i - un_map[vec[i]] <= k) {
      return true;
    }
    un_map[vec[i]] = i;
  }
  return false;
}
int main() {
  std::vector<int> vec = {1, 2, 3, 2, 4};
  std::cout << constainDuplicate(vec, 2) << std::endl;
}
