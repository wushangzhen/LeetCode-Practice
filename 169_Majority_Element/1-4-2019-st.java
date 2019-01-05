public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int res = 0;
        int count = 0;
        for (int num : nums) {
            //if (count == 0) {
            //    res = num;
            //    count++;
            //} else if (res != num) {
            //    count--;
            //} else {
            //    count++;
            //}
            if (num == res) {
                count++;
            } else if (count == 0) {
                res = num;
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
