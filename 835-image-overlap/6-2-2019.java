class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    list1.add(new int[]{i, j});
                }
                if (B[i][j] == 1) {
                    list2.add(new int[]{i, j});
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] a : list1) {
            for (int[] b : list2) {
                String str = "" + (a[0] - b[0]) + " " + (a[1] - b[1]);
                map.put(str, map.getOrDefault(str, 0) + 1);
                max = Math.max(max, map.get(str));
            }
        }
        return max;
    }
}
