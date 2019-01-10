class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int right = 0;
        int n = nums.length;
        String str = "";
        while (right < n) {
            str += nums[right] + "->";
            int end = right;
            while (end != n - 1 && nums[end + 1] - nums[end] == 1) {
                end++;
            }
            if (end != right) {
                str += nums[end] + "->";
                right = end;
            }
            res.add(str.substring(0, str.length() - 2));
            str = "";
            right++;
        }
        return res;
    }
}
