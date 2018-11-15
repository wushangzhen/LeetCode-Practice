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
 class IntervalCmp implements Comparator<Interval> {
     public int compare(Interval a, Interval b) {
         if (a.start == b.start) {
             return a.end - b.end;
         } 
         return a.start - b.start;
     }
 }

public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        List<Interval> res = new LinkedList<>();
        for (Interval interval : list1) {
            res.add(interval);
        }
        for (Interval interval : list2) {
            res.add(interval);
        }
        Collections.sort(res, new IntervalCmp());
        for (int i = 0; i < res.size(); i++) {
            if (i != 0) {
                if (res.get(i).start <= res.get(i - 1).end) {
                    if (res.get(i - 1).end < res.get(i).end) {
                        res.get(i - 1).end = res.get(i).end;
                    }
                    res.remove(i);
                    i--; // conner case
                }
            }
        }
        return res;
    }
}
