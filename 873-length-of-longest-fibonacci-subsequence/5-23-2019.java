class Solution {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        int n = A.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = A[i];
                int b = A[j];
                int res = 2;
                while (set.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    res++;
                }
                max = Math.max(res, max);
            }
        }
        return max > 2 ? max : 0;
    }
}
