class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // may have some initial variable
        map.put(0, 0);
        int sum = 0;
        int max = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
