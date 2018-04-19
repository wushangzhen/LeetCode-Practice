#include <iostream>
#include <map>
#include <vector>

bool containsDuplicate(std::vector<int> vec, int k, int t) {
  std::map<long long, int> m;
  int j = 0;
  for (int i = 0; i < vec.size(); i++) {
    if (i - j > k) {
      m.erase(vec[j++]);
    }
    long long temp = (long long)vec[i] - t;
    auto a = m.lower_bound(temp);
    long long temp2 = (long long)a->first - vec[i];
    if (a != m.end() && std::abs(temp2) <= t) {
      return true;
    }
    m[vec[i]] = i;
  }
  return false;  
}

int main() {
  std::vector<int> vec = {1, 2};
  std::cout << containsDuplicate(vec, 0, 1) << std::endl; 
}
