class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] strs1 = A.split(" ");
        String[] strs2 = B.split(" ");
        for (String str : strs1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : strs2) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String str : strs1) {
            if (map.get(str) == 1) {
                ans.add(str);
            }
        }
        for (String str : strs2) {
            if (map.get(str) == 1) {
                ans.add(str);
            }
        }
        return ans.toArray(new String[0]);
    }
}
