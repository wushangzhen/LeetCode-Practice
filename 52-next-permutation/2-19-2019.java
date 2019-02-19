class Solution {
    //1,2,3 
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int i = n - 1;
        for (; i >= 0; i--) {
            if (i != n - 1 && nums[i] < nums[i + 1]) { // 从右向左找到不符合升序的那个数
                break;
            }
        } 
        if (i == -1) {
            reverse(0, n - 1, nums);
            return;
        }
        int j = n - 1;
        for (; j > i; j--) {
            if (nums[j] > nums[i]) { // 找到第一个大于nums[i]的数，然后进行交换。
                break;
            }
        }
        swap(i, j, nums);
        reverse(i + 1, n - 1, nums);
        return;
    }
    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void reverse(int start, int end, int[] nums) {
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
}
