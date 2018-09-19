class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class Solution {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        Comparator<Pair> pairComparator = new Comparator<Pair>() {
            public int compare(Pair left, Pair right) {
                return arrs[left.row][left.col] - arrs[right.row][right.col];
            }
        };
        if (arrs == null || arrs.length == 0) {
            return 0;
        }
        Queue<Pair> heapPair = new PriorityQueue<Pair>(arrs.length, pairComparator);
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] != null && arrs[i].length != 0) {
                Arrays.sort(arrs[i]);
                heapPair.offer(new Pair(i, 0));
            }
        }
        int intersection = 0;
        int count = 0;
        Pair last = new Pair(0, 0);
        while (!heapPair.isEmpty()) {
            Pair pair = heapPair.poll();
            if (arrs[pair.row][pair.col] != arrs[last.row][last.col]
                || count == 0) {
                    if (count == arrs.length) {
                        intersection++;
                    }
                    count = 1;
            } else {
                count++;
            }
            int newCol = pair.col + 1;
            if (newCol < arrs[pair.row].length) {
                heapPair.offer(new Pair(pair.row, newCol));
            }
            last = pair;
        } 
        if (count == arrs.length) {
            intersection++;
        }
        return intersection;
    }
}
