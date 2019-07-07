class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                res.add(i);
            }
        }
        while (n > 2) {
            n -= res.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : res) {
                for (int x : map.get(i)) {
                    map.get(x).remove(i);
                    if (map.get(x).size() == 1) {
                        newLeaves.add(x);
                    }
                }
            }
            res = newLeaves;
        }
        return res;
    }
}
