class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            int diff = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
            sum += 2 * diff;
            maxDiff = Math.max(maxDiff, diff - (Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1])));
        }
        return sum - maxDiff;
    }
}
