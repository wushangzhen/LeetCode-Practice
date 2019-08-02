class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = indexes.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            String s = sources[i];
            int index = indexes[i];
            if (S.substring(index, index + s.length()).equals(s)) {
                map.put(index, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length() - 1;
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
