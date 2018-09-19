public class Solution {
    /**
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // write your code here
        if (input == null || input.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] sum = new int[input.length() + 1];
        for (String line : input.split("\n")) {
            int level = line.lastIndexOf('\t') + 2; 
            int len = line.length() - (level - 1);
            if (line.contains(".")) {
                ans = Math.max(ans, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;
            }
        }
        return ans;
    }
}
