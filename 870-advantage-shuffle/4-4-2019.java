class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortA = A.clone();
        Arrays.sort(sortA);
        int[] sortB = B.clone();
        Arrays.sort(sortB);
        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        Deque<Integer> remaining = new LinkedList<>();
        int j = 0;
        for (int b : sortB) {
            assigned.put(b, new LinkedList<>());
        }
        for (int a : sortA) {
            if (a > sortB[j]) {
                assigned.get(sortB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }
        int[] res = new int[A.length];
        int i = 0;
        for (int b : B) {
            if (assigned.get(b).size() == 0) {
                res[i++] = remaining.pop();
            } else {
                res[i++] = assigned.get(b).pop();
            }
        }
        return res;
    }
}
