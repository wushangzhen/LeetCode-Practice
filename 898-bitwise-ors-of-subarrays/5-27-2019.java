class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> cur = new HashSet<>(), res = new HashSet<>(), cur2;
        for (int i : A) {
            cur2 = new HashSet<>();
            cur.add(i);
            for (int j : cur) {
               cur2.add(i | j); 
            }
            res.addAll(cur = cur2);
        }
        return res.size();
    }
}
