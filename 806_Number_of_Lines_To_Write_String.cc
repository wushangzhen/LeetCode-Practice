#include <iostream>
#include <vector>
#include <string>
std::vector<int> numberOfLines(std::vector<int>& widths, std::string S) {
  int lines = 1;
  int units = 0;
  for (auto s : S) {
       units += widths[s - 'a'];
    if (units == 100) {
       lines++; 
       units = 0;
    }
    if (units > 100) {
      lines++;
      units = widths[s - 'a'];
    } 
  }
  std::vector<int> vec_result;
  vec_result.push_back(lines);
  vec_result.push_back(units);
  return vec_result;
}

int main() {
  std::string str("bbbcccdddaaa");
  std::vector<int> width = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, vec;
  vec = numberOfLines(width, str);
  std::cout << vec[0] << " " << vec[1] << std::endl;
  
}
