class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    ans += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            }
            if (height[left] >= height[right]) {
                if (height[right] < rightMax) {
                    ans += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
