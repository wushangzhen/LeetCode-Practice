class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            list.add(nums[i]);
            while (left < right) {
                if (left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right != n - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == -nums[i]) {
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(new ArrayList<>(list));
                    left++;
                    right--;
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
            list.remove(list.size() - 1);
        }
        return res;
        
    }
}
