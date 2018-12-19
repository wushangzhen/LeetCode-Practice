public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    // 1 2 3 4 5
    // 5 4 3 2 1
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return new ArrayList<>();
        } 
        int index1 = -1;
        int n = nums.size();
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && nums.get(i) > nums.get(i + 1)) {
                index1 = i;
                break;
            }
        }
        if (index1 == -1) {
            reverse(0, nums);
            return nums;
        }
        int index2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums.get(i) < nums.get(index1)) {
                index2 = i;
                break;
            }
        }
        swap(nums, index1, index2);
        reverse(index1 + 1, nums);
        return nums;
    }
    void swap(List<Integer> nums, int index1, int index2) {
        int temp = nums.get(index1);
        nums.set(index1, nums.get(index2));
        nums.set(index2, temp);
    }
    void reverse(int start, List<Integer> nums) {
        int end = nums.size() - 1;
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
