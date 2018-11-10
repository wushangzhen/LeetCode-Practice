class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] visit = new boolean[n];
        dfs(0, nums, visit, new LinkedList<>(), res);
        return res;
    }
    
    void dfs(int start, int[] nums, boolean[] visit, List<Integer> list, List<List<Integer>> res) {
        if (start > nums.length) {
            return;
        }
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i - 1] == nums[i] && !visit[i - 1]) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            dfs(i + 1, nums, visit, list, res);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
