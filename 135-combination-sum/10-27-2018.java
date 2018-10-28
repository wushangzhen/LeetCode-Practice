public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(0, candidates, res, new LinkedList<>(), target);
        return res;
    }
    void dfs(int start, int[] candidates, List<List<Integer>> res,
        List<Integer> list, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > 0 && candidates[i - 1] == candidates[i]) { 
                continue;
            }
            list.add(candidates[i]);
            dfs(i, candidates, res, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
