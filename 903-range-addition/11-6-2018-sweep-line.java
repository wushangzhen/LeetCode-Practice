public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int n = length;
        int[] array = new int[n + 1];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1] + 1;
            int value = updates[i][2];
            array[start] += value;
            array[end] -= value;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = array[i];
                continue;
            }
            res[i] = res[i - 1] + array[i];
        }
        return res;
    }
}
