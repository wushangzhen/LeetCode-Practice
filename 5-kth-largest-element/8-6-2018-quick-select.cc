class Solution {
public:
    /*
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    int kthLargestElement(int n, vector<int> &nums) {
        // write your code here
        if (nums.empty()) {
            return -1;
        }
        return quickSort(nums, 0, nums.size() - 1, n);
     }
private:
    int quickSort(vector<int> &nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int i = start, j = end;
        int pivot = nums[(i + j) / 2];
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (start + k - 1 <= j) {
            return quickSort(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return quickSort(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }
};
