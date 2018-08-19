class Solution {
public:
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    vector<vector<int>> threeSum(vector<int> &numbers) {
        // write your code here
        vector <vector<int>> results;
        if (numbers.empty() && numbers.size() < 3) {
            return results;
        } 
        sort(numbers.begin(), numbers.end());
        for (int i = 0; i < numbers.size() - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1, right = numbers.size() - 1;
            int target = - (numbers[i]);
            twoSum(numbers, left, right, target, results);
        }
        return results;
    }
    void twoSum(vector<int> &numbers,
                int left,
                int right,
                int target,
                vector<vector<int>> &results) {
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                vector<int> vec(3);
                vec[0] = -(target);
                vec[1] = numbers[left];
                vec[2] = numbers[right]; 
                results.push_back(vec);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }                
    }
};
