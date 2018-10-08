public class Solution {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String ss = String.valueOf(sc);
            if (!map.containsKey(ss)) {
                map.put(ss, new ArrayList<String>());
            }
            map.get(ss).add(s);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
