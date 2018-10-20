class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            } else {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            }
        }
        return max;
    }
}
