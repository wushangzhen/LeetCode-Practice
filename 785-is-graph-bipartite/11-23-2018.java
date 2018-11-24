class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            memo.put(i, 0);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (memo.get(i) == 0) {
                q.add(i);
                memo.put(i, 1);
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int k = 0; k < size; k++) {
                        int temp = q.poll();
                        for (int j : graph[temp]) {
                            if (memo.get(j) == memo.get(temp)) {
                                return false;
                            }
                            if (memo.get(j) == 0) {
                                if (memo.get(temp) == 1) {
                                    memo.put(j, 2);
                                }
                                if (memo.get(temp) == 2) {
                                    memo.put(j, 1);
                                }
                                q.add(j);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
