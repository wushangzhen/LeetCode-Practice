class Solution {
    public int minFlipsMonoIncr(String S) {
        int flipCount = 0;
        int onesCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                if (onesCount == 0) {
                    continue;
                } else {
                    flipCount++;
                }
            } else {
                onesCount++;
            }
            if (flipCount > onesCount) {
            flipCount = onesCount;
            }
        }
        return flipCount;
    }
}
