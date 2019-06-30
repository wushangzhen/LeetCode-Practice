class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = -1;
        for (int a : A) {
            int b = K - a;
            if (b < 0) {
                continue;
            } else {
                Integer lower = set.lower(b);
                if (lower != null) {
                    res = Math.max(res, a + lower);
                }
            }
            set.add(a);
        }
        return res;
    }
}
