class Point {
    int index;
    int num;
    public Point(int index, int num) {
        this.index = index;
        this.num = num;
    }
}

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, nums[0]));
        int count = 0;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point temp = q.poll();
                if (temp.index == n - 1) {
                    return count;
                }
                for (int j = 1; j <= temp.num; j++) {
                    if (temp.index + j < nums.length && !visited[temp.index + j]) {
                        visited[temp.index + j] = true;
                        q.add(new Point(temp.index + j, nums[temp.index + j]));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
