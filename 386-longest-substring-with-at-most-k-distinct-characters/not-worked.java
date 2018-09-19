public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0){
            return 0;
        }
        char[] sc = s.toCharArray();
        int result = Integer.MIN_VALUE;
        Set set = new HashSet();
        Map<Character, Integer> map = new HashMap();
        int i = 0;
        int j = 0;
        while (j < sc.length) {
            if (set.size() < k) {
                set.add(sc[j]);
                if (!map.containsKey(sc[j])) {
                    map.put(sc[j], 1);
                } else {
                    int value = map.get(sc[j]);
                    map.put(sc[j], ++value);
                }
                j++;
                System.out.println(i);
                System.out.println(j);
                System.out.println("--------");
                result = Math.max(result, j - i);
            } else {
                while (set.size() == k && i <= j) {
                    int value = map.get(sc[i]);
                    map.put(sc[i], --value);
                    if (map.get(sc[i]) == 0) {
                        set.remove(sc[i]);
                    }
                    i++;
                }
            }
        }
        return result;
    }
}
