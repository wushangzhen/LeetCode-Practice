public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int n = org.length;
        Map<Integer, Integer> degree = new HashMap<>();
        int count = 0;
        for (int[] seq : seqs) {
            for(int i = 0; i < seq.length; i++) {
                count++;
                degree.putIfAbsent(seq[i], 0);
                if (i != 0) {
                    degree.put(seq[i], degree.get(seq[i]) + 1);
                }
                if (!edges.containsKey(seq[i])) {
                    edges.put(seq[i], new ArrayList<>());
                }
                if (i + 1 < seq.length) {
                    edges.get(seq[i]).add(seq[i + 1]);
                }
            }
        }
        if (count < n) {
            return false;
        }
        count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }
        while (!q.isEmpty()) {
            if (q.size() > 1) {
                return false;
            }
            int k = q.poll();
            if (count >= n || k != org[count]) {
                return false;
            }
            count++;
            if (edges.containsKey(k)) {
                for (int edge : edges.get(k)) {
                    degree.put(edge, degree.get(edge) - 1);
                    if (degree.get(edge) == 0) {
                        q.add(edge);
                    }
                }
            }
        }
        return count == n;
    }
}
