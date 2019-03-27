class ResultType {
    int index;
    int val;
    public ResultType(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
class Solution {
    Map<Integer, ResultType> memo = new HashMap<>();
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = quiet.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] rich : richer) {
            map.get(rich[1]).add(rich[0]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(map, quiet, i).index;
        }
        return res;
    }
    private ResultType dfs(Map<Integer, List<Integer>> map, int[] quiet, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int index = i;
        int val = quiet[i];
        List<Integer> list = map.get(i);
        for (int item : list) {
            ResultType rt = dfs(map, quiet, item);
            if (rt.val < val) {
                val = rt.val;
                index = rt.index;
            }
        }
        ResultType rt = new ResultType(index, val);
        memo.put(i, rt);
        return rt;
    }
}
