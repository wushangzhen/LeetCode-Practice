class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int right = 1;
        int count = 1;
        int res = 1;
        int pre = 0;
        int pos = 1; // 找到相应需要插入的位置，一旦位置不相等就插入
        while (right < n) {
            if (nums[right] == nums[pre]) {
                if (count > 0) {
                    count--;
                    res++;
                    if (pos != right) {
                        nums[pos] = nums[right];
                    }
                    pos++;
                }
            } else {
                count = 1;
                res++;
                if (pos != right) {
                    nums[pos] = nums[right];
                }
                pos++;
                pre = right;
            }
            right++;
        }
        return res;
    }
}
