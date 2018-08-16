#include <iostream>
#include <string>
#include <map>

bool wordPattern(string pattern, string str) {
  map<string, int> str_i_map;
  map<char, int> char_i_map;
  int i = 0, n = pattern.length();
  istringstream in(str);
  for (string word; in >> word; i++) {
    if (i == n || str_i_map[word] != char_i_map[patter[i]]) {
      return false;
    }
    str_i_map[word] = char_i_map[pattern[i]] = i + 1;
  }
  return i == n;
}
