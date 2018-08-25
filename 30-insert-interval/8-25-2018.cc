/**
 * Definition of Interval:
 * classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        // write your code here
        vector<Interval> result;
        int index = 0;
        while (index < intervals.size() && 
               intervals[index].start < newInterval.start) {
            index++;           
        }
        intervals.insert(intervals.begin() + index, newInterval);
        Interval* last = NULL;
        for (int i = 0; i < intervals.size(); i++) {
            if (last == NULL || last->end < intervals[i].start) {
                result.push_back(intervals[i]);
                last = &result[result.size() - 1];// do not write last = intervals[i] it will not change the value of results;
            } else {
                last->end = std::max(intervals[i].end, last->end);
            }
        }
        return result;
    }
};
