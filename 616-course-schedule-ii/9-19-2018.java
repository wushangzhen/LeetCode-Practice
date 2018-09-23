public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            if (!edges.containsKey(prerequisites[i][1])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(prerequisites[i][0]);
                edges.put(prerequisites[i][1], list);
            } else {
                edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int num = queue.poll();
            order[count] = num;
            count++;
            if (edges.containsKey(num)) {
                for (int i = 0; i < edges.get(num).size(); i++) {
                    degree[edges.get(num).get(i)]--;
                    if (degree[edges.get(num).get(i)] == 0) {
                        queue.add(edges.get(num).get(i));
                    }
                }
            }
        }
        if (count == numCourses) {
            return order;
        }
        return new int[0]; 
    }
}
