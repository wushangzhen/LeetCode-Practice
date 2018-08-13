class Solution {
public:
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    vector<int> nextPermutation(vector<int> &nums) {
        // write your code here
        if (nums.empty()) {
            return nums;
        }
        int len = nums.size();
        int flag = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > nums[i - 1] && i > 0) {
                flag = i;
                for (int j = len - 1; j >= 0; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swapItem(nums[j], nums[i - 1]);
                        break;
                    }    
                }
                break;
            }
        }
        swapSequence(flag, nums);
        return nums;
    }
private:
    void swapItem(int &A, int &B) {
        int temp = A;
        A = B;
        B = temp;
    }
    void swapSequence(int left, vector<int> &vec) {
        int right = vec.size() - 1;
        while (right > left) {
            swapItem(vec[right], vec[left]);
            right--;
            left++;
        }
    }
    
};
