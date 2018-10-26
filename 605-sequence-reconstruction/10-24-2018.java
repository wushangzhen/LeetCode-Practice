public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i : org) {
            map.put(i, new HashSet<>());
            indegree.put(i, 0);
        } 
        int n = org.length;
        int count = 0;
        for (int[] seq : seqs) {
            count += seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) {
                return false;
            }
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > n) {
                    return false;
                }
                if (map.get(seq[i - 1]).add(seq[i])) {
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }
        if (count < n) {
            return false;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                q.add(key);
            }
        }
        int cnt = 0;
        while (q.size() == 1) {
            int ele = q.poll();
            for (int next : map.get(ele)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    q.add(next);
                }
            }
            if (ele != org[cnt]) {
                return false;
            }
            cnt++;
        }
        return cnt == org.length;
    }
}
