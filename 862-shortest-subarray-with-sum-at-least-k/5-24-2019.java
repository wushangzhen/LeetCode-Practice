class Solution {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = A.length;
        int[] B = new int[n + 1];
        for (int i = 0; i < n; i++) {
            B[i + 1] = B[i] + A[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            while (!dq.isEmpty() && B[i] - B[dq.getFirst()] >= K) {
                ans = Math.min(ans, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && B[i] <= B[dq.getLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
