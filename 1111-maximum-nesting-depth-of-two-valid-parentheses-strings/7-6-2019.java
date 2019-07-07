class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int A = 0, B = 0;
        int[] res = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                if (A < B) {
                    A++;
                } else {
                    B++;
                    res[i]++;
                }
            } else {
                if (A < B) {
                    B--;
                    res[i]++;
                } else {
                    A--;
                }
            }
        }
        return res;
    }
}
