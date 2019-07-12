class Solution {
    public int minDeletionSize(String[] A) {
        int res = 0;
        int n = A[0].length();
        for (int i = 0; i < n; i++) {
            char prev = (char)('a' - 1);
            for (String a : A) {
                if (a.charAt(i) - prev < 0) {
                    res++;
                    break;
                }
                prev = a.charAt(i);
            }
        }
        return res;
    }
}
