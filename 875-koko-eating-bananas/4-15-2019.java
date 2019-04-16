class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int start = 1;
        int end = 0;
        for (int i = 0; i < piles.length; i++) {
            if (end < piles[i]) {
                end = piles[i];
            }
        }
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int[] temp = piles.clone();
            int h = helper(temp, mid);
            if (h > H) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int[] temp = piles.clone();
        if (helper(temp, start) <= H) {
            return start;
        } else {
            return end;
        }
    }
    int helper(int[] piles, int w) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += piles[i] / w;
            if (piles[i] % w != 0) { // pay attention to this
                count++;
            }
        }
        return count;
    }
}
