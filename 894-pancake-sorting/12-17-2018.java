public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        // Write your code here
        if (array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        while (n > 1) {
            int index = findMax(n, array);
            FlipTool.flip(array, index);
            FlipTool.flip(array, n - 1);
            n--;
        }
    }
    int findMax(int n, int[] array) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < array[i]) {
                index = i;
                max = array[i];
            }
        }
        return index;
    }
}
