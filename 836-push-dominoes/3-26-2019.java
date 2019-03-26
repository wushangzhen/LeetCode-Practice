class Solution {
    public String pushDominoes(String S) {
        char[] A = S.toCharArray();
        int N = A.length;
        int[] forces = new int[N];
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R') {
                force = N;
            } else if (A[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }
        force = 0;
        for (int i = N - 1; i >= 0; --i) {
            if (A[i] == 'L') {
                force = N;
            } else if (A[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }
        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f == 0) {
                sb.append('.');
            } else if (f > 0) {
                sb.append('R');
            } else {
                sb.append('L');
            }
        }
        return sb.toString();
    }
}
