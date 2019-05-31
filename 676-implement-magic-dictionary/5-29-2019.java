class MagicDictionary {

    /** Initialize your data structure here. */
    Map<Integer, Set<String>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            map.putIfAbsent(str.length(), new HashSet<>());
            map.get(str.length()).add(str);
        }
        
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (!map.containsKey(word.length())) {
            return false;
        }
        for (String str : map.get(word.length())) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (str.charAt(i) != word.charAt(i)) {
                    count++;
                }
                if (count >= 2) {
                    break;
                }
            }
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
