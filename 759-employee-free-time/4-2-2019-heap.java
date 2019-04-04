/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        if (schedule.size() == 0) {
            return list;
        }
        for (List<Interval> employee : schedule) {
            for (Interval iv : employee) {
                list.add(iv);
            }
        }
        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        Interval temp = list.get(0);
        for (Interval v : list) {
            if (temp.end < v.start) {
                res.add(new Interval(temp.end, v.start));
            }
            if (temp.end < v.end) {
                temp = v;
            }
        }
        return res;
    }
}
