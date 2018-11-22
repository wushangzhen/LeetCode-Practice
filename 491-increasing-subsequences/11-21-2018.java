class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Set<List<Integer>> set = new HashSet<>();
        dfs(0, nums, new LinkedList<>(), set);
        res = new ArrayList<>(set);
        return res;
    }
    void dfs(int start, int[] nums, List<Integer> list, Set<List<Integer>> set) {
        if (start == nums.length) {
            if (list.size() > 1) {
                set.add(new ArrayList<>(list));
            }
            return;
        }
        if (list.size() > 1) {
            set.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
               continue;
            }
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                dfs(i + 1, nums, list, set);
                list.remove(list.size() - 1);
            }
        } 
    }
}
