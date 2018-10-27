public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        dfs(0, num, target, new LinkedList<>(), res, visited);
        return res;
    }
    void dfs(int start, int[] num, int target, 
        List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }        
        for (int i = start; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (i > 0 && num[i] == num[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(num[i]);
            visited[i] = true;
            dfs(i + 1, num, target - num[i], list, res, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
