public class Solution {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        int[] hash = new int[256];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        List<Integer> result = new ArrayList<>();
        if (pc.length > sc.length) {
            return result;
        }
        for (int i = 0; i < pc.length; i++) {
            hash[pc[i]]--;
            hash[sc[i]]++;
        }
        int addSum = 0;
        for (int item : hash) {
            addSum += Math.abs(item);
        }
        if (addSum == 0) {
            result.add(0);
        }
        for (int i = pc.length; i < sc.length; i++) {
            int r = sc[i];
            int l = sc[i - pc.length];
            addSum = addSum - Math.abs(hash[r]) - Math.abs(hash[l]); // don't know why
            hash[r]++;
            hash[l]--;
            addSum = addSum + Math.abs(hash[r]) + Math.abs(hash[l]);
            if (addSum == 0) {
                result.add(i - pc.length + 1);
            }
        }
        return result;
    }
}
