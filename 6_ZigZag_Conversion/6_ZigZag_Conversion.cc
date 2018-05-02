#include <iostream>
#include <vector>
#include <string>
string convert(string s, int numRows) {
  int n = 2 * numRows - 2;
  vector<string> vec;
  for (int i = 0; i < s.length(); i++) {
    int temp = i;
    temp %= n
    if (temp < numRows) { 
      vec[temp] += s[i];
    } else {
      vec[numRows - n - temp]
    }
  }      
}
