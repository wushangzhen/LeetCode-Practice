public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] array : prerequisites) {
            for (int i = 0; i < array.length; i++) {
                if (!map.containsKey(array[1])) {
                    map.put(array[1], new ArrayList<>());
                }
                List<Integer> list = map.get(array[1]);
                list.add(array[0]);
                map.put(array[1], new ArrayList<>(list));
                degree[array[0]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            if (map.containsKey(temp)) { // This has to be there, important
                List<Integer> list = map.get(temp);
                for (int i : list) {
                    degree[i]--;
                    if (degree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
