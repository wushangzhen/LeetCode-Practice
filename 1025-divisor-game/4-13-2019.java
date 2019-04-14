class Solution {
    public boolean divisorGame(int N) {
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                return !divisorGame(N - i);
            }
        }
        return false;
    }
}
