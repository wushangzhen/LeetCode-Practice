class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int i : ages) {
            count[i]++;
        }
        int[] preSum = new int[121];
        for (int i = 1; i < 121; i++) {
            preSum[i] = preSum[i - 1] + count[i];
        }
        int res = 0;
        for (int i = 15; i < 121; i++) {
            int left = i / 2 + 7;
            int temp = preSum[i] - preSum[left];
            res += count[i] * temp - count[i]; 
        }
        return res;
    }
}
