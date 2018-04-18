#include <iostream>
#include <string>
std::string addBinary(std::string a, std::string b) {
  std::string s = "";
  
  int c = 0, i = a.size() - 1, j = b.size() - 1;
  while(i >= 0 || j >= 0 || c == 1)
  {
      c += i >= 0 ? a[i --] - '0' : 0;
      c += j >= 0 ? b[j --] - '0' : 0;
      s = char(c % 2 + '0') + s;
      c /= 2;
  }
  
  return s;
}

std::string addBinary2(std::string a, std::string b) {
  std::string s = "";

  int i = a.length();
  int j = b.length();
  while (j < i) {
    b.insert(b.begin(), '0');
    j++;
  }
  while (j > i) {
    a.insert(a.begin(), '0');
    i++;
  }
  int temp = i - 1;
  int tep = 0;
  int c = 0;
  while (temp != -1) {
    tep = (a[temp] - '0') + (b[temp] - '0') + c;
    if (tep > 1) {
      c = 1; 
      tep = tep % 2;
    } else {
      c = 0;
    }
    s.insert(s.begin(), char(tep));
    if (temp == 0 && c == 1) {
      s.insert(s.begin(), '1');
    }

    temp--;
  }
  return s;
}

int main() {
  std::string str1 = "1010";
  std::string str2 = "1011";
  std::cout << addBinary2(str1, str2) << std::endl;
}
