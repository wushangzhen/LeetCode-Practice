public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        Map<Integer, List<Integer>> hash = new HashMap<>();
        int[] inDegree = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        } 
        int n = prerequisites.length;
        int m = prerequisites[0].length;
        if (m == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (!hash.containsKey(prerequisites[i][1])) {
                hash.put(prerequisites[i][1], new ArrayList<Integer>());
            } 
            List<Integer> temp = hash.get(prerequisites[i][1]);  
            temp.add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
            hash.put(prerequisites[i][1], temp);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            count++;
            if (hash.containsKey(i)) {
                List<Integer> temp = hash.get(i);
                for (int elem : temp) {
                    inDegree[elem]--;
                    if (inDegree[elem] == 0) {
                        queue.add(elem);
                    }
                }
            }
        }
        return count == numCourses;
        
    }
}
