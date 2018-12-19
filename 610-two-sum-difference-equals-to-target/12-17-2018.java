public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + target)) {
                return new int[]{map.get(nums[i] + target) + 1, i + 1};
            }
            if (map.containsKey(nums[i] - target)) {
                return new int[]{map.get(nums[i] - target) + 1, i + 1};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
