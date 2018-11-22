class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(0, nums, new LinkedList<>(), res);
        return res;
    }
    void dfs(int start, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (start == nums.length) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((list.size() == 0 || nums[i] >= list.get(list.size() - 1)) && !set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
                dfs(i + 1, nums, list, res);
                list.remove(list.size() - 1);
            }
        } 
    }
}
