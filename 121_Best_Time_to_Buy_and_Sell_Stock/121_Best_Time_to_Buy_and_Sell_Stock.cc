#include <iostream>
#include <vector>
using namespace std;
int maxProfit(vector<int> &prices) {
  int profit = 0;
  if (prices.size() == 0) {
    return 0;
  }
  int min_price = prices[0];
  int max_price = 0;
  int count = 0;
  for (int i = 0; i < prices.size(); i++) {
    if (min_price > prices[i]) {
      min_price = prices[i];
    } else if (min_price < prices[i] && profit < prices[i] - min_price) {
      profit = prices[i] - min_price;
    }
  }
  return profit;
  //if (prices.size() == 0) {
  //  return 0;
  //}
  //for (int i = 0; i < prices.size(); i++) {
  //  if (prices[i] < min_price && i != prices.size() - 1) {
  //    min_price = prices[i];
  //    count = i;
  //  }
  //}
  //if (count == prices.size() - 1) {
  //  return profit;
  //}
  //max_price = min_price;
  //for (int i = count; i < prices.size(); i++) {
  //  if (prices[i] > max_price) {
  //    max_price = prices[i];
  //  } 
  //} 
  //profit = max_price - min_price;
  //return profit;
}
int main() {
  vector<int> vec = {7,1,5,3,6,4};
  std::cout << maxProfit(vec) << std::endl;
}
