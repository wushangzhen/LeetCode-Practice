public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i - 1]
                || i % 2 == 0 && nums[i] > nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
            }
        }
    }
}
