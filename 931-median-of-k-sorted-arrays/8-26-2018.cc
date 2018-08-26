class Solution {
public:
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    double findMedian(vector<vector<int>> &nums) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        int totalNumber = getTotalNumber(nums);
        int upperBound = INT_MIN;
        int lowerBound = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i].size() == 0) {
                continue;
            }
            lowerBound = min(nums[i][0], lowerBound);
            upperBound = max(nums[i][nums[i].size() - 1], upperBound);
        }
        if (totalNumber % 2 != 0) {
            return findKth(nums, totalNumber / 2 + 1, upperBound, lowerBound);
        }
        long long result = findKth(nums, totalNumber / 2, upperBound, lowerBound) 
                + findKth(nums, totalNumber / 2 + 1, upperBound, lowerBound);
        return result / 2.0;
    }
    int getTotalNumber(vector<vector<int>>& nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i].size() == 0) {
                continue;
            }
            sum += nums[i].size();
        } 
        return sum;
    }
    long long findKth(vector<vector<int>>& nums, int k, int end, int start) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (lessEqualNum(nums, mid) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (lessEqualNum(nums, start) == k) {
            return start;
        } else {
            return end;
        }
    }
    int lessEqualNum(vector<vector<int>>& nums, int value) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += lessEqualNum(nums[i], value);
        }
        return sum;
    }
    int lessEqualNum(vector<int>& num, int value) {
        if (num.size() == 0) {
            return 0;
        }
        int start = 0; 
        int end = num.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] <= value) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (num[start] > value) {
            return start;
        }
        if (num[end] > value) {
            return end;
        }
        return num.size();
    }
};
