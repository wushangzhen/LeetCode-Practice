class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < str.length(); i++) {
                if ((i & 1) == 0) {
                    even[str.charAt(i) - 'a']++;
                } else {
                    odd[str.charAt(i) - 'a']++;
                }
            }
            String sig = Arrays.toString(odd) + Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
       
    }
}
