class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        int n = nums.length;
        boolean[] visited = new boolean[n];
        dfs(0, nums, visited, new LinkedList<>(), res);
        return res;
    }
    void dfs(int count, int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (count == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(count + 1, nums, visited, list, res);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
