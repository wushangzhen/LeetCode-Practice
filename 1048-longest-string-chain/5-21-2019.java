class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b)->(a.length() - b.length()));
        int max = 1;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(words[i])) {
                continue;
            } else {
                map.put(words[i], 1);
                for (int j = 0; j < words[i].length(); j++) {
                    StringBuilder sb = new StringBuilder(words[i]);
                    String pre = sb.deleteCharAt(j).toString();
                    if (map.containsKey(pre)) {
                        if (map.get(pre) + 1 > map.get(words[i])) {
                            map.put(words[i], map.get(pre) + 1);
                        }
                    }
                }
                max = Math.max(map.get(words[i]), max);
            } 
        }   
        return max;
    }
}
