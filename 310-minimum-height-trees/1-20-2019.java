class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> topo = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            topo.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            topo.get(edge[0]).add(edge[1]);
            topo.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < topo.size(); i++) {
            if (topo.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                for (int item : topo.get(i)) {
                    topo.get(item).remove(i);
                    if (topo.get(item).size() == 1) {
                        newLeaves.add(item);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
