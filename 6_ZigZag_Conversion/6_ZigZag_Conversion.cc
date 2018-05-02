#include <iostream>
#include <vector>
#include <string>
using namespace std;
string convert(string s, int numRows) {
  if (s.length() == 0 || numRows == 0) {
      return "";
  }
  if (numRows == 1) {
    return s;
  }
  int n = 2 * numRows - 2;
  vector<string> vec(numRows, ""); // better initialize
  for (int i = 0; i < s.length(); i++) {
    int temp = i;
    temp %= n;
    if (temp < numRows) { 
      vec[temp] += s[i];
    } else {
      vec[numRows - ((temp + 1) % numRows) - 1] += s[i];
    }
  }
  if (vec.size() == 0) {
      return "";
  }
  string result = "";
  for (int i = 0; i < vec.size(); i++) {
    result += vec[i];
  }
  return result;
} 

int main() {
  string str = "PAYPALISHIRING";
  std::cout << convert(str, 3) << std::endl;
}
