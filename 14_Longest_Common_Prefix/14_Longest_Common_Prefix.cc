#include <iostream>
#include <vector>
#include <string>

std::string longestCommonPrefix(std::vector<std::string>& strs) {
   std::string strRes = ""; 
   if (str[0] == "") {
     return "";
   }
   std::str0 = strs[0];
   int i = 0;
   int j = 0;
   while (j < str0.length()) {
     if (str[i].length() == 0) {
       return "";
     }
     while (str0[j] == strs[i][j] && i < strs.size()) {
       i++;
     } 
     if (i == strs.size()) {
       strRes += str0[j];
       i = 0;
     } else {
       break;
     }
     j++;
   }
   return strRes;
}
int main() {
  std::vector<std::string> vec = {"dog"};
  std::cout << longestCommonPrefix(vec) << std::endl;
}
