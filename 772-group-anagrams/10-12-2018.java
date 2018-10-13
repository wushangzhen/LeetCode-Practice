class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sc = str.toCharArray();
            Arrays.sort(sc);
            String temp = String.valueOf(sc);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
