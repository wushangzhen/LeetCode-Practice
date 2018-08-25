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
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    vector<Interval> mergeTwoInterval(vector<Interval> &list1, vector<Interval> &list2) {
        // write your code here
        vector<Interval> result;
        int size1 = list1.size();
        int index = 0;
        for (int i = 0; i < list2.size(); i++) {
            for (int j = index; j < list1.size(); j++) {
                if (index < list1.size() && list1[j].start < list2[i].start) {
                    index++;
                }
            }
            list1.insert(list1.begin() + index, list2[i]);
        }
        Interval* last = NULL;
        for (auto item : list1) {
            if (last == NULL || last->end < item.start) {
                result.push_back(item);
                last = &result[result.size() - 1];
            } else {
                last->end = std::max(item.end, last->end);
            }
        }
        return result;
    }
};
