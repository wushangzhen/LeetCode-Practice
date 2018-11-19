class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i]) && hash.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = hash.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }
}
