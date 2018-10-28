public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            if (isRepeat(nums, i)) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
    boolean isRepeat(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] 
                && (((n & (1 << (i - 1))) == 0) && ((n & (1 << i)) != 0))) {
                return true;        
            }
        }
        return false;
    }
}
