public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int p1 = 0;
        int p2 = 0;
        int n = nums.length;
        while (p2 < n) {
            if (!set.contains(nums[p2])) {
                nums[p1] = nums[p2];
                set.add(nums[p2]);
                p1++;
            }
            p2++;
        }
        return set.size();
    }
}
