class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        int max = 1;
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                if (dp.get(j).containsKey(diff)) {
                    dp.get(i).put(diff, dp.get(j).get(diff) + 1);
                } else {
                    dp.get(i).put(diff, 2);
                }
                max = Math.max(max, dp.get(i).get(diff));
            }
        }
        return max;
    }
}
