public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    private int MissingNum = -1;
    public int findMissing(int[] nums) {
        // write your code here
        int N = nums.length;
        int sum1 = 0;
        for (int elem : nums) {
            sum1 += elem;
        }
        return (N * (N + 1) / 2) - sum1;
    }
}
