#include <iostream>
int climbStairsHelp(int n) {
  if (n <= 2) {
    return n; 
  }
  return climbStairsHelp(n - 1) + climbStairsHelp(n - 2);
}
int climbStairs(int n) {
  return climbStairsHelp(n); 
}

int climbStairs2(int n) {
  int prev = 0;
  int cur = 1;
  for (int i = 0; i < n; i++) {
    int temp = cur;
    cur = cur + prev;
    prev = temp;
  }
  return cur;
}

