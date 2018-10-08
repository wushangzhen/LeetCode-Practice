public class Solution {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        // count method
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (Character c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                temp.append(count[i]);
                temp.append("#");
            }
            String key = temp.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
        
        //for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        //    results.add(entry.getValue());
        //}
        //return results;
    }
}
