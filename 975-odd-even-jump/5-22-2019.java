class Solution {
    public int oddEvenJumps(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = A.length;
        int res = 1;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry hi = map.ceilingEntry(A[i]);
            Map.Entry lo = map.floorEntry(A[i]);
            if (hi != null) {
                higher[i] = lower[(int)hi.getValue()];
            }
            if (lo != null) {
                lower[i] = higher[(int)lo.getValue()];
            }
            if (higher[i]) {
                res++;
            }
            map.put(A[i], i);
        }
        return res;
    }
}
