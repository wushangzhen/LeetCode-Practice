/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        List<Interval> res = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < list1.size() && p2 < list2.size()) {
            if (list1.get(p1).start <= list2.get(p2).start) {
                if (res.size() == 0 || res.get(res.size() - 1).end < list1.get(p1).start) {
                    res.add(list1.get(p1));
                } else if (res.get(res.size() - 1).end >= list1.get(p1).start) {
                    res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, list1.get(p1).end);
                }
                p1++;
            } else {
                if (res.size() == 0 || res.get(res.size() - 1).end < list2.get(p2).start) {
                    res.add(list2.get(p2));
                } else if (res.get(res.size() - 1).end >= list2.get(p2).start) {
                    res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, list2.get(p2).end);
                }
                p2++;
            }
        }
        while (p1 < list1.size()) {
            if (res.size() == 0 || res.get(res.size() - 1).end < list1.get(p1).start) {
                res.add(list1.get(p1));
            } else if (res.get(res.size() - 1).end >= list1.get(p1).start) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, list1.get(p1).end);
            }
            p1++;
        }
        while (p2 < list2.size()) {
            if (res.size() == 0 || res.get(res.size() - 1).end < list2.get(p2).start) {
                res.add(list2.get(p2));
            } else if (res.get(res.size() - 1).end >= list2.get(p2).start) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, list2.get(p2).end);
            }
            p2++;
        }
        return res;
    }
}
