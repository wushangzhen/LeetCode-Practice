class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i != 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (target >= candidates[i]) {
                list.add(candidates[i]);
                dfs(i, list, candidates, target - candidates[i], res);
                list.clear();
            }
        }
        return res;
    }
    void dfs(int start, List<Integer> list, int[] candidates, int sum, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start + 1; i < candidates.length; i++) {
            if (sum < candidates[i]) {
                break;
            }
            if (i != start + 1 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (sum >= candidates[i]) {
                list.add(candidates[i]);
                dfs(i, list, candidates, sum - candidates[i], res);
                list.remove(list.size() - 1);
            } 
        }
    }
}
