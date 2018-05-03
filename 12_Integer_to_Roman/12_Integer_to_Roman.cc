#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
string intToRoman(int num) {
  unordered_map <int, string> un_map = {{1, "I"}, {5, "V"}, {10, "X"}, {50, "L"},
      {100, "C"}, {500, "D"}, {1000, "M"}};
  int temp = num;
  string str = "";
  int digit = 0;
  if (temp >= 1000) {
    digit = temp / 1000;
    int count = digit;
    while (count--) {
      str += un_map[1000];
    }
    temp = temp - digit * 1000;
  }
  if (temp >= 100) {
    digit = temp / 100;
    if (digit < 4) {
      int count = digit;
      while (count--) {
        str += un_map[100];
      }
    }
    if (digit == 4) {
      str = str + un_map[100] + un_map[500];
    }
    if (digit >= 5 && digit < 9) {
      str += un_map[500];
      int count = digit;
      count -= 5;
      while (count--) {
        str += un_map[100]; 
      }
    }
    if (digit == 9) {
      str += un_map[100];
      str += un_map[1000];
    }
    temp = temp - 100 * digit;
  }
  if (temp >= 10) {
    digit = temp / 10;
    if (digit < 4) {
      int count = digit;
      while (count--) {
        str += un_map[10];
      }
    }
    if (digit == 4) {
      str = str + un_map[10] + un_map[50];
    }
    if (digit >= 5 && digit < 9) {
      str += un_map[50];
      int count = digit;
      count -= 5;
      while (count--) {
        str += un_map[10]; 
      }
    }
    if (digit == 9) {
      str += un_map[10];
      str += un_map[100];
    }
    temp = temp - 10 * digit;
  }
  if (temp > 0 && temp < 10) {
    int digit = temp;
    if (digit < 4) {
      int count = digit;
      while (count--) {
        str += un_map[1];
      }
    }
    if (digit == 4) {
      str = str + un_map[1] + un_map[5];
    }
    if (digit >= 5 && digit < 9) {
      str += un_map[5];
      int count = digit;
      count -= 5;
      while (count--) {
        str += un_map[1]; 
      }
    }
    if (digit == 9) {
      str += un_map[1];
      str += un_map[10];
    }
  }
  return str;
}
int main() {
  cout << intToRoman(11) << endl;
}
