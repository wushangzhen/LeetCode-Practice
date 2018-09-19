class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        return quickSelect(0, nums.length - 1, k - 1, nums);
    }
    public int quickSelect(int start, int end, int k, int[] nums) {
        if (start >= end) {
            return nums[start];
        }
        int pivot = nums[(start + end) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j, nums);
                i++;
                j--;
            }
        }
        if (k <= j) {
            return quickSelect(start, j, k, nums);
        }
        if (k >= i) {
            return quickSelect(i, end, k, nums);
        }
        return nums[k];
    } 
    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};
