public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(0, nums, res, new LinkedList<>(), visited);
        return res;
    }
    void dfs(int start, int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        res.add(new LinkedList<>(list));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(i + 1, nums, res, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
