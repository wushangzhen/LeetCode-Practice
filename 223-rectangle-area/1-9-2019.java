class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (E >= C || G <= A || H <= B || D <= F) {
            return sum; // 注意不相交的情况
        }
        return sum - (Math.min(D, H) - Math.max(B, F)) * (Math.min(G, C) - Math.max(A, E));
    }
}
