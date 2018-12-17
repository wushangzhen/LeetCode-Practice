class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                res[0] = hash.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            hash.put(nums[i], i);
        }
        return new int[0];
    }
}
