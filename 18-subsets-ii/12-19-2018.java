class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        dfs(0, nums, new LinkedList<>(), res);
        return res;
    }
    void dfs(int start, int[] nums, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            dfs(i + 1, nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}
