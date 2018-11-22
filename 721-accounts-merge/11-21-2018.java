class Solution {
    Map<Integer, Integer> father;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        father = new HashMap<>();
        Map<String, List<Integer>> emailToId = email2Id(accounts);
        for (String email : emailToId.keySet()) {
            List<Integer> list = emailToId.get(email);
            for (int i = 1; i < list.size(); i++) {
                union(list.get(i), list.get(0));
            }
        }
        List<List<String>> res = new ArrayList<>();
        Map<Integer, Set<String>> idToEmail = id2Email(accounts);
        for (Map.Entry<Integer, Set<String>> entry : idToEmail.entrySet()) {
            List<String> list = new LinkedList<>(entry.getValue());
            Collections.sort(list);
            list.add(0, accounts.get(entry.getKey()).get(0));
            res.add(list);
        }
        return res;
        
    }
    Map<Integer, Set<String>> id2Email(List<List<String>> accounts) {
        Map<Integer, Set<String>> res = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            int rootId = find(i);
            res.putIfAbsent(rootId, new HashSet<>());
            for (int j = 1; j < account.size(); j++) {
                res.get(rootId).add(account.get(j));
            }
        }
        return res;
    }
    Map<String, List<Integer>> email2Id(List<List<String>> accounts) {
        Map<String, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                res.putIfAbsent(account.get(j), new ArrayList<>());
                res.get(account.get(j)).add(i);
            }
        }
        return res;
    }
    int find(int a) {
        List<Integer> path = new ArrayList<>();
        while (father.containsKey(a)) {
            path.add(a);
            a = father.get(a);
        }
        for (int id : path) {
            father.put(id, a);
        }
        return a;
    }
    void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 != root2) {
            father.put(root1, root2);
        }
    }
}
