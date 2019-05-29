class Solution {
    public int numDupDigitsAtMostN(int N) {
        List<Integer> L = new ArrayList<>();
        for (int x = N + 1; x > 0; x /= 10) {
            L.add(0, x % 10);
        }
        int res = 0;
        int n = L.size();
        // count digit < n
        for (int i = 1; i < n; i++) {
            res += 9 * A(9, i - 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j) {
                if (!seen.contains(j)) {
                    res += A(9 - i, n - i - 1);
                }
            }
            if (seen.contains(L.get(i))) {
                break;
            }
            seen.add(L.get(i));
        }
        return N - res;
    }
    int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }
}
