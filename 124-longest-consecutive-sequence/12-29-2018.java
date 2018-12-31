class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            if (set.contains(x)) {
                count = 1;
                int left = x - 1;
                while (set.contains(left)) {
                    count++;
                    set.remove(left);
                    left--;
                }
                int right = x + 1;
                while (set.contains(right)) {
                    count++;
                    set.remove(right);
                    right++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
