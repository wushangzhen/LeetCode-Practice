public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        int n = candidates.length;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        dfs(0, sum, list, result, candidates, target);
        return result;
    }
    void dfs(int startIndex, int sum, List<Integer> list, List<List<Integer>> result, 
        int[] candidates, int target) {
            if (sum == target) {
                result.add(new ArrayList<>(list));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (i != startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                dfs(i, sum + candidates[i], list, result, candidates, target);
                list.remove(list.size() - 1);
            }
            
        }
}
