class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int ptr1 = nums[0];
        while (ptr1 != slow) {
            ptr1 = nums[ptr1];
            slow = nums[slow];
        }
        return slow;
    }
}
