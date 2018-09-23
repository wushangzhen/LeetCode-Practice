public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        //List[] edges = new ArrayList[numCourses];
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            if (!edges.containsKey(prerequisites[i][1])) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                edges.put(prerequisites[i][1], list);
            } else {
                edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            System.out.println(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            if (edges.containsKey(course)) {
                int n = edges.get(course).size();
                for (int i = 0; i < n; i++) {
                    int pointer = edges.get(course).get(i);
                    degree[pointer]--;
                    if (degree[pointer] == 0) {
                        queue.add(pointer);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
