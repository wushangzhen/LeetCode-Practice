class Solution {
    Random rand;
    List<Integer> pSum;
    int tot;
    public Solution(int[] w) {
        tot = 0;
        pSum = new ArrayList<>();
        rand = new Random();
        for (int ww : w) {
            tot += ww;
            pSum.add(tot);
        }
    }
    
    public int pickIndex() {
        int targ = rand.nextInt(tot);
        int start = 0;
        int end = pSum.size() - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (pSum.get(mid) <= targ) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (pSum.get(start) > targ) {
            return start;
        } else {
            return end;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
