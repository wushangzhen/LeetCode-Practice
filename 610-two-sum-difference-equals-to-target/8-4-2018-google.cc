#include <iostream>
#include <vector>
using namespace std;
int solution(vector<int> &nums, int target) {
    int len = nums.size();
    for (int i = 0; i < len; i++) {
        nums[i] *= nums[i];
    }
    int j = 1;
    int count = 0;
    for (int i = 0; i < len; i++) {
        while (j < len && nums[j] - nums[i] < target) {
            j++;
        }
        if (nums[j] - nums[i] >= target && j != i) {
            count += (j - i - 1); 
        }
    }
    return count;
}

int main() {
    int a[5] = {1, 1, 2, 3, 5};
    vector<int> input(a, a + 5);
    cout << solution(input, 4) << endl;
}
