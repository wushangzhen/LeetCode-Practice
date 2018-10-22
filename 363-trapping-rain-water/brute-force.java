class Solution {
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            int max = Math.min(leftMax, rightMax);
            ans += max - height[i];
        }
        return ans;  
    }
}
