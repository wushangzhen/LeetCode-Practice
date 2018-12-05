/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
 
 class Node {
     Interval interval;
     int row;
     int col;
     public Node(Interval interval, int row, int col) {
         this.interval = interval;
         this.row = row;
         this.col = col;
     }
 }
 class NodeComp implements Comparator<Node> {
     public int compare(Node node1, Node node2) {
         if (node1.interval.start == node2.interval.start) {
             return node2.interval.end - node2.interval.end;
         }
         return node1.interval.start - node2.interval.start;
     }
 }


public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        Queue<Node> q = new PriorityQueue<>(new NodeComp());
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).size() > 0) {
                q.add(new Node(intervals.get(i).get(0), i, 0));
            }
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (res.size() == 0 || res.get(res.size() - 1).end < node.interval.start) {
                res.add(node.interval);
            } else {
                if (res.get(res.size() - 1).end < node.interval.end) {
                    res.get(res.size() - 1).end = node.interval.end;
                }
            }
            if (node.col + 1 < intervals.get(node.row).size()) {
                q.add(new Node(intervals.get(node.row).get(node.col + 1), node.row, node.col + 1));
            }
        }
        return res;
    }
}
