public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> path = new ArrayList<>();
        Set<Integer> hash = new HashSet<>();
        dfs(nums, path, hash, result);
        return result;
    }
    void dfs(int[] nums, List<Integer> path, Set<Integer> hash, 
        List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!hash.contains(nums[i])) {
                path.add(nums[i]);
                hash.add(nums[i]);
                dfs(nums, path, hash, result);
                path.remove(path.size() - 1);
                hash.remove(nums[i]);
            }
        }
    }
}
