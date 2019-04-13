class Solution {
    Map<Integer, Integer> cntMap;
    Map<Integer, Set<Integer>> squareMap;
    int cnt = 0;
    public int numSquarefulPerms(int[] A) {
        cntMap = new HashMap<>();
        squareMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            cntMap.put(A[i], cntMap.getOrDefault(A[i], 0) + 1);
            squareMap.putIfAbsent(A[i], new HashSet<>());
        }
        // construct the relationship let square number connected
        for (int i : cntMap.keySet()) {
            for (int j : cntMap.keySet()) {
                double sum = Math.sqrt(i + j);
                if (sum == Math.floor(sum)) {
                    squareMap.get(i).add(j);
                    squareMap.get(j).add(i);
                }
            }
        }
        for (int i : cntMap.keySet()) {
            dfs(i, cntMap, squareMap, A.length - 1);
        }
        return cnt;
    }
    void dfs(int num, Map<Integer, Integer> cntMap, Map<Integer, Set<Integer>> squareMap, int n) {
        cntMap.put(num, cntMap.get(num) - 1);
        if (n == 0) {
            cnt++; // 不要return，否则无法backtracing
        } else {
            Set<Integer> set = squareMap.get(num);
            for (int i : set) {
                if (cntMap.get(i) != 0) {
                    dfs(i, cntMap, squareMap, n - 1);
                }
            }
        }
        cntMap.put(num, cntMap.get(num) + 1);
    }
}
