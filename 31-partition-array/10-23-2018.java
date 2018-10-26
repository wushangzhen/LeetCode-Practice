public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
在quickSort() 和 quickSelect() 的partition方法中，为了保持左右区间均衡，=k的数一次往左放，一次往右放，所以最后end < start 时，可能会出现三个区间，[0, end], [end+1], [start, n-1]。 这三段区间要分别处理。

此题中要求<k 的数往左放，>= k的数往右放，所以最后只会有两段区间：[0, end]] 和 [start, n-1]。start最后指向第一个应该放在右边区间的数，即>=k的数。
