class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> memo = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            memo.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            memo.get(path[0]).add(path[1]);
            memo.get(path[1]).add(path[0]);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int[] colors = new int[5];
            for (int j : memo.get(i + 1)) {
                colors[res[j - 1]] = 1;
            }
            for (int j = 1; j < 5; j++) {
                if (colors[j] == 0) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
