class Solution {
    int res = 0;
    public int countArrangement(int N) {
        Set<Integer> visited = new HashSet<>();
        dfs(1, N, visited);
        return res;
    }
    void dfs(int pos, int N, Set<Integer> visited) {
        if (visited.size() == N) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited.contains(i) || (i % pos != 0 && pos % i != 0)) {
                continue;
            }
            visited.add(i);
            dfs(pos + 1, N, visited);
            visited.remove(i);
        }
    }
}
