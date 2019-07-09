class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i : nums) {
            if (i > first) {
                third = second;
                second = first;
                first = i;
            } else if (i > second && i < first) {
                third = second;
                second = i;
            } else if (i > third && i < second) {
                third = i;
            }
        }
        return third == Long.MIN_VALUE ? (int)first : (int)third;
    }
}
