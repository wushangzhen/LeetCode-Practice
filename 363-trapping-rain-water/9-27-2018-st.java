public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int left = 0, right = heights.length - 1;
        int res = 0;
        if (left >= right) {
            return res;
        }
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        while (left < right) {
            if (leftHeight < rightHeight) { // left smaller 
            // search from the left
                left++;
                if (leftHeight > heights[left]) {
                    res += (leftHeight - heights[left]);
                } else {
                    leftHeight = heights[left];
                }
            } else {
                right--;
                if (rightHeight > heights[right]) {
                    res += (rightHeight - heights[right]);
                } else {
                    rightHeight = heights[right];
                }
            }
        }
        return res;
    }
}
