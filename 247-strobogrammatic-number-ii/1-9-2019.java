class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Integer, List<String>> memo = new HashMap<>();
        List<String> l = new ArrayList<>();
        l.add("");
        memo.put(0, l);
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("8");
        memo.put(1, list);
        return find(n, n, memo);
    }
    List<String> find(int m, int n, Map<Integer, List<String>> memo) {
        if (memo.containsKey(m)) {
            return memo.get(m);
        }
        List<String> list = find(m - 2, n, memo);
        List<String> res = new ArrayList<>();
        for (String a : list) {
            if (m != n) {
                res.add("0" + a + "0");
            }
            res.add("1" + a + "1");
            res.add("6" + a + "9");
            res.add("9" + a + "6");
            res.add("8" + a + "8");
        }
        memo.put(m, res);
        return res;
        
    }
}
