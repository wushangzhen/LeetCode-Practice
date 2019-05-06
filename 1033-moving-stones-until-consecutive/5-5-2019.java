class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] A = {a, b, c};
        Arrays.sort(A);
        if (A[2] - A[0] == 2) {
            return new int[2];
        }
        return new int[]{Math.min(A[1] - A[0], A[2] - A[1]) <= 2 ? 1 : 2, A[2] - A[0] - 2};
    }
}
