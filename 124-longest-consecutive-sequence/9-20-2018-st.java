public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int item : num) {
            set.add(item);
        }
        int ans = 0;
        for (int item : num) {
            if (set.contains(item)) {
                set.remove(item);
                int l = item - 1;
                int r = item + 1;
                while (set.contains(l)) {
                    set.remove(l);
                    l--;
                }
                while (set.contains(r)) {
                    set.remove(r);
                    r++;
                }
                ans = Math.max(ans, r - l - 1);
            }
        }
        return ans
    }
}
