class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (set1.contains(str)) {
                set2.add(str);
            }
            set1.add(str);
        }
        return new ArrayList<>(set2);
    }
}
