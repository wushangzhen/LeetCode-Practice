class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[n];
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
            graph.putIfAbsent(pre[0], new ArrayList<>())
        }
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                que.add(i);
            }
        }
        
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int m = que.poll();
                count++;
                List<Integer> list = graph.get(m);
                for (Integer x : list) {
                    degree[x]--;
                    if (degree[x] == 0) {
                        que.add(x);
                    }
                }
            } 
        }
        return count == n;
    }
}
