class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> topo = new HashMap<>();
        int n = org.length;
        int[] degree = new int[n + 1];
        Arrays.fill(degree, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (org[i] <= 0 || org[i] > n) {
                return false;
            }
            topo.put(org[i], new ArrayList<>());
            degree[org[i]] = 0;
        }
        int cnt = 0;
        for (int i = 0; i < seqs.size(); i++) {
            cnt += seqs.get(i).size();
            for (int j = 0; j < seqs.get(i).size(); j++) {
                if (!topo.containsKey(seqs.get(i).get(j)) || 
                    (j + 1 < seqs.get(i).size() && !topo.containsKey(seqs.get(i).get(j + 1)))) {
                    return false;
                } else if (j + 1 < seqs.get(i).size()) {
                    topo.get(seqs.get(i).get(j)).add(seqs.get(i).get(j + 1));
                    degree[seqs.get(i).get(j + 1)]++;
                }
            }
        }
        if (cnt < n) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) {
            return false;
        }
        int count = 0;
        while (!q.isEmpty()) {
            if (q.size() != 1) {
                return false;
            }
            int temp = q.poll();
            if (count < n && temp != org[count++]) {
                return false;
            }
            List<Integer> list = topo.get(temp);
            for (Integer item : list) {
                degree[item]--;
                if (degree[item] == 0) {
                    q.add(item);
                }
            }
        }
        return count == n;
    }
}
