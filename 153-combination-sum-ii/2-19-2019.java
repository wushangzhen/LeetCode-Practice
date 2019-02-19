class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        int n = candidates.length;
        boolean[] visited = new boolean[n];
        helper(-1, new ArrayList<>(), candidates, target, res, visited);
        return res;
    }
    void helper(int start, List<Integer> list, int[] candidates, int target, List<List<Integer>> res, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start + 1; i < candidates.length; i++) {
            if (i != start + 1 && candidates[i - 1] == candidates[i] && !visited[i - 1]) {
                continue;
            }
            if (target >= candidates[i]) {
                visited[i] = true;
                list.add(candidates[i]);
                helper(i, list, candidates, target - candidates[i], res, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
