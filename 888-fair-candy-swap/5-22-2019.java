class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int suma = 0;
        int sumb = 0;
        for (int a : A) {
            suma += a;
        }
        for (int b : B) {
            sumb += b;
        }
        int[] res = new int[2];
        int d = (sumb - suma) / 2;
        Set<Integer> set = new HashSet<>();
        for (int b : B) {
            set.add(b);
        }
        for (int a : A) {
            if (set.contains(d + a)) {
                res[0] = a;
                res[1] = d + a;
            }
        }
        return res;
    }
}
