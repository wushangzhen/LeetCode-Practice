#include <iostream>
#include <vector>

using namespace std;

int maxProfit(vector<int>& prices) {
  int total = 0;
  for (int i = 0; i < prices.size() - 1; i++) {
    if (prices[i] < prices[i + 1]) {
      total += (prices[i + 1] - prices[i]);
    }
  }
  return total;
}
