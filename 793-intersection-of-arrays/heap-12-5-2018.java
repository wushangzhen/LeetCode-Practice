class Pair {
    int row;
    int col;
    int val;
    public Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
public class Solution {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        if (arrs == null || arrs.length == 0) {
            return 0;
        }
        int n = arrs.length;
        Queue<Pair> q = new PriorityQueue(new Comparator<Pair>(){
            public int compare(Pair pair1, Pair pair2) {
                return pair1.val - pair2.val;
            }
        });
        for (int i = 0; i < n; i++) {
            if (arrs[i].length == 0) {
                return 0;
            } else {
                Arrays.sort(arrs[i]);
                q.add(new Pair(i, 0, arrs[i][0]));
            }
        }
        int intersection = 0;
        int count = 0;
        Pair last = q.peek();
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.val == last.val) {
                intersection++;
                if (intersection == n) {
                    count++;
                    intersection = 1;
                }
            } else {
               intersection = 1;
            }
            if (arrs[cur.row].length > cur.col + 1) {
                q.add(new Pair(cur.row, cur.col + 1, arrs[cur.row][cur.col + 1]));
            }
            last = cur;
        }
        return count;
    }
}
