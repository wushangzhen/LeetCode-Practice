#include <iostream>
#include <set>

using namespace std;
int nthUglyNumber(int n) {
  int count = 0;
  int num = 1;
  int result = 1;
  while (count != n) {
    for (int i = 2; i < 6; i++) {
      while (num % i == 0) {
        num /= i;
      }
    }
    if (num == 1) {
      count++;
    }
    if (count == n) {
      continue;
    }
    result++;
    num = result;
  }
  return result;
} // time limit exceeded


int nthUglyNumber2(int n) {
  set<long long> order;
  order.insert(1);
  int count = 0;
  long long curmin = 0;
  while (count != n) {
    curmin = *(order.begin()); 
    order.erase(order.begin());
    order.insert(curmin * 2);
    order.insert(curmin * 3);
    order.insert(curmin * 5);
    count++;
  }
  return int (curmin);
}
int main() {
  std::cout << nthUglyNumber2(10) << std::endl;
}
