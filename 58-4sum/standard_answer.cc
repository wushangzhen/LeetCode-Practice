class Solution {
public:
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    vector<vector<int>> fourSum(vector<int> &numbers, int target) {
        // write your code here
        sort(numbers.begin(), numbers.end());
        vector<vector<int>> results;
        if (numbers.empty() || numbers.size() < 4) {
            return results;
        }
        for (int i = 0; i < numbers.size() - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.size() - 2; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = numbers.size() - 1;
                while (left < right) {
                    int sum = numbers[left] + numbers[right] + numbers[i] + numbers[j];
                    if (sum == target) {
                            vector<int> result;
                            result.push_back(numbers[i]);
                            result.push_back(numbers[j]);
                            result.push_back(numbers[left]);
                            result.push_back(numbers[right]);
                            results.push_back(result);
                            left++;
                            right--;
                            while (left < right && numbers[left] == numbers[left - 1]) {
                                left++;
                            }
                            while (left < right && numbers[right] == numbers[right + 1]) {
                                right--;
                            }
                            
                            
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return results;
    }
};
