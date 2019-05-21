class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int even = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even += A[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[queries[i][1]] % 2 == 0) {
                even -= A[queries[i][1]];
            }
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]] % 2 == 0) {
                even += A[queries[i][1]];
            }
            res[i] = even;
        }
        return res;
    }
}
