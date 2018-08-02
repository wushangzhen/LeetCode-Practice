#include <vector>
#include <set>
#include <algorithm>
#include <iostream>
using namespace std;
class Solution {
public:
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    vector<int> twoSum(vector<int> &numbers, int target) {
        // write your code here
        set<int> set1;
        vector<int> pair;
        for (int i = 0; i < numbers.size(); i++) {
            if (set1.find(target - numbers[i]) != set1.end()) {
                pair.push_back(find(numbers.begin(), numbers.end(), 
                    target - numbers[i]) - numbers.begin());
                pair.push_back(i);
                return pair; 
            }
            cout << numbers[i] << endl;
            set1.insert(numbers[i]);
        }
        return pair;
    }
};
int main() {
    int a[4] = {2, 7, 11, 15};
    vector<int> input(a, a + 4);
    vector<int> output;
    Solution s;
    output = s.twoSum(input, 9);
    cout << output[0] << "," << output[1] << endl;

}
