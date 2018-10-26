public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        int n = org.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            map.put(org[i], new HashSet<>());
            degree.put(org[i], 0);
        }
        for (int[] seq : seqs) {
            count += seq.length;
            if (seq.length >= 1) {
                if (seq[0] <= 0 || seq[0] > n) {
                    return false;
                }
                for (int i = 1; i < seq.length; i++) {
                    if (seq[i] <= 0 || seq[i] > n) {
                        return false;
                    }
                    if (map.get(seq[i - 1]).add(seq[i])) {
                        degree.put(seq[i], degree.get(seq[i]) + 1);
                    }
                }
            }
        }
        if (count < n) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> it : degree.entrySet()) {
            if (it.getValue() == 0) {
                q.add(it.getKey());
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 1) {
                return false;
            }
            int value = q.poll();
            if (value != org[cnt]) {
                return false;
            } else {
                Set<Integer> set = map.get(value);
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    int key = it.next();
                    degree.put(key, degree.get(key) - 1);
                    if (degree.get(key) == 0) {
                        q.add(key);
                    }
                }
                cnt++;
            }
        }
        return cnt == n;
    }
}
