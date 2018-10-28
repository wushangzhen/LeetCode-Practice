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
        dfs(0, nums, res, new LinkedList<>());
        return res;
    }
    void dfs(int start, int[] nums, List<List<Integer>> res, List<Integer> list) {
        res.add(new LinkedList<>(list));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(i + 1, nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}
