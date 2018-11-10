class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(0, nums, new LinkedList<>(), res);
        return res;
    }
    void dfs(int start, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (start > nums.length) {
            return;
        }
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i + 1, nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}
