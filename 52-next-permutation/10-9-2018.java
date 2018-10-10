public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int n = nums.length;
        if (n == 0) {
            return nums; 
        }
        int index = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == n - 1) {
            swapList(0, n - 1, nums);
            return nums;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[index]) {
                swap(i, index, nums);
                break;
            }
        }
        swapList(index + 1, n - 1, nums);
        return nums;
    }
    void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    void swapList(int start, int end, int[] nums) {
        while (start <= end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
}
