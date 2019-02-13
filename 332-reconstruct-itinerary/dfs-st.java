class Solution {
    Map<String, List<String>> topo = new HashMap<>();
    int numOfTicket = 0;
    int n = 0;
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {
        numOfTicket = tickets.length;
        for (String[] ticket : tickets) {
            topo.putIfAbsent(ticket[0], new LinkedList<>());
        }
        for (String[] ticket : tickets) {
            topo.get(ticket[0]).add(ticket[1]);
        }
        for (String str : topo.keySet()) {
            Collections.sort(topo.get(str));
        }
        res.add("JFK");
        dfs("JFK");
        return res;
    }
    void dfs(String start) {
        if (!topo.containsKey(start)) {
            return;
        }
        List<String> list = topo.get(start);
        for (int i = 0; i < list.size(); i++) {
            n++;
            String str = list.get(i);
            res.add(str);
            list.remove(i);
            dfs(str);
            if (n == numOfTicket) {
                return;
            }
            n--;
            res.remove(res.size() - 1);
            list.add(i, str);
        }
    }
}
