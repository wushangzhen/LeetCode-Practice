class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] max = new int[n];
        int count = 0;
        max[0] = arr[0];
        if (arr[0] == 0) {
            count++;
        }
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
            if (max[i] == i) {
                count++;
            }
        } 
        return count;
    }
}
