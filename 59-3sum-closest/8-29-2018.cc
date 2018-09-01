class Solution {
public:
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    int threeSumClosest(vector<int> &numbers, int target) {
        // write your code here
        if (numbers.empty()) {
            return -1;
        }
        int min = INT_MAX;
        int left = 0;
        int right = 0;
        int result = 0;
        sort(numbers.begin(), numbers.end());
        for (int i = 0; i < numbers.size(); i++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (numbers[i] + numbers[left] + numbers[right] <= target) { 
                    int temp = min;
                    min = std::min(abs(numbers[left] + numbers[right] +
                                       numbers[i] - target), min);
                    if (temp != min) {
                        result = numbers[i] + numbers[left] + numbers[right];
                    }
                    left++;
                } else {
                    int temp = min;
                    min = std::min(abs(numbers[left] + numbers[right] +
                                       numbers[i] - target), min);
                    if (temp != min) {
                        result = numbers[i] + numbers[left] + numbers[right];
                    }
                    right--;
                }
             }
        }
        return result;
    }
};
