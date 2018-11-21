public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int n, int[][] prerequisites) {
        // write your code here
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] degree = new int[n];
        for (int[] prerequisite : prerequisites) {
            edges.putIfAbsent(prerequisite[1], new ArrayList<>());
            edges.putIfAbsent(prerequisite[0], new ArrayList<>());// this is important every nodes should have a list
            edges.get(prerequisite[1]).add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        int[] res= new int[n];
        while (!queue.isEmpty()) {
            int i = queue.poll();
            res[count] = i;
            count++;
            if (edges.containsKey(i)) { // this is also important, what if some courses are not showed in prerequisites
                for (int j : edges.get(i)) {
                    degree[j]--;
                    if (degree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }
        return count == n ? res : new int[0];
        
    }
}
