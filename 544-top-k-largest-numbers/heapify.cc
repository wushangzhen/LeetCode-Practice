class Solution {
public:
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    int size = 0;
    vector<int> topk(vector<int> &nums, int k) {
        // write your code here
        if (nums.empty()) {
            return nums;
        }
        heapify(nums);
        vector<int> result;
        int initSize = nums.size();
        for (int i = 0; i < initSize - k; i++) {
            pop(nums);
        }
        for (int i = 0; i < k; i++) {
            result.push_back(pop(nums));
        }
        reverse(result.begin(), result.end());
        return result;
    }
    void heapify(vector<int>& nums) {
        this->size = nums.size();
        for (int i = size / 2; i >= 0; i--) {
            siftDown(nums, i);
        }
    }
    void siftDown(vector<int>& nums, int index) {
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int min = index;
            if (left < size && nums[left] < nums[min]) {
                min = left;
            }
            if (right < size && nums[right] < nums[min]) {
                min = right;
            }
            if (min != index) {
                swap(nums[index], nums[min]);
                index = min;
            } else {
                break;
            }
        }
    }
    void swap(int& a, int& b) {
        int temp = a;
        a = b;
        b = temp;
    }
    int pop(vector<int>& nums) {
        int top = nums[0];
        int max = nums[size - 1];
        size--;
        nums[0] = max;
        siftDown(nums, 0);
        return top;
    }
};
