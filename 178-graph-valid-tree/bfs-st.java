class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            if (set.contains(i)) {
                return false;
            }
            for (Integer k : graph.get(i)) {
                q.add(k);
                graph.get(k).remove(i);
            }
            set.add(i);
        }
        return set.size() == n;
    }
}
