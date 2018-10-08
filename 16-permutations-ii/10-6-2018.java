public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            result.add(path);
            return result;
        }
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        dfs(nums, path, result, visited);
        return result;
    }
    void dfs(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (i != 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, path, result, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
};
