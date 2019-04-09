class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        int right = 0;
        int count = 0;
        for (int i = 0; i < clips.length;) {
            if (clips[i][0] > right) {
                return -1;
            }
            int cur = right;
            while (i < clips.length && clips[i][0] <= right) {
                cur = Math.max(cur, clips[i][1]);
                i++;
            }
            count++;
            right = cur;
            if (cur >= T) {
                return count;
            }
        }
        return -1;
    }
}
