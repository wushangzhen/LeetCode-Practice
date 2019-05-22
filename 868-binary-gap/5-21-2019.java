class Solution {
    public int binaryGap(int N) {
        int last = -1, max = 0;
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) != 0) {
                if (last >= 0) {
                    max = Math.max(max, i - last);
                }
                last = i;
            }
        }
        return max;
    }
}
