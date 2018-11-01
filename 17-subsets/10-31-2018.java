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
        helper(0, nums, new LinkedList<>(), res);
        return res;
    }
    void helper(int start, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (start > nums.length) {
            return;
        }
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(i + 1, nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}
