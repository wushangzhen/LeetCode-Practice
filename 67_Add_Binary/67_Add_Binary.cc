#include <iostream>
string addBinary(string a, string b) {
  string s = "";
  
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

string addBinary2(string a, string b) {
  string s = "";

  int i = a.length();
  int j = b.length();
  int temp = 0;
  temp = i > j ? j : i;
  temp--;
  int c = 0;
  int tep;
  while (temp != -1) {
    if (b[temp])
    tep = std::stoi(a[temp]) + std::stoi(b[temp]) + c;
    if (tep > 1) {
      c == 1 
      tep = tep % 2;
    } else {
      c == 0;
    }
    s.insert(s.bigin(), tep.to_string());
    temp--;
  }
  if (c == 0 && i > j) {
    for (temp = i - j - 1; temp != 0; temp--) {
    
    }
    s.insert(s.bigin(), tep.to_string());
    
  }
}
