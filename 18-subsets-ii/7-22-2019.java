class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums); // important
        helper(0, nums, visited, new ArrayList<>(), res);
        return res;
    }
    void helper(int start, int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(i + 1, nums, visited, list, res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
