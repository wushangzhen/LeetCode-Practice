class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, res, graph, list);
        return res;
    }
    void dfs(int start, List<List<Integer>> res, int[][] graph, List<Integer> list) {
        if (start == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i : graph[start]) {
            list.add(i);
            dfs(i, res, graph, list);
            list.remove(list.size() - 1);
        }
    }
}
