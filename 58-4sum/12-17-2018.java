class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int value1 = target - nums[i];
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int value2 = value1 - nums[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    if (left != j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right != n - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    if (nums[left] + nums[right] == value2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } 
                    if (nums[left] + nums[right] < value2) {
                        left++;
                    } 
                    if (nums[left] + nums[right] > value2) {
                        right--;
                    } 
                }
            }
        }
        return res;
    }
}
