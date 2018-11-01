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
        helper(0, nums, new LinkedList<>(), res, visited);
        return res;
    }
    void helper(int start, int[] nums, List<Integer> list, List<List<Integer>> res, 
        boolean[] visited) {
        if (start > nums.length) {
            return;
        }
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(i + 1, nums, list, res, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
