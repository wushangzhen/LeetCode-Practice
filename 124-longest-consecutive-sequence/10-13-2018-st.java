class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            set.add(i);
        }
        int ans = 0;
        for (Integer item : nums) {
            if (set.contains(item)) {
                set.remove(item);
                int l = item;
                int r = item;
                while (set.contains(l - 1)) {
                    set.remove(l - 1);
                    l--;
                }
                while (set.contains(r + 1)) {
                    set.remove(r + 1);
                    r++;
                }
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
