public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        dfs(0, new LinkedList<>(), res, nums);
        return res;
    }
    void dfs(int start, List<Integer> list, List<List<Integer>> res, int[] nums) {
        if (start > nums.length) {
            return;
        }
        res.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i + 1, list, res, nums);
            list.remove(list.size() - 1);
        }
    }
}
