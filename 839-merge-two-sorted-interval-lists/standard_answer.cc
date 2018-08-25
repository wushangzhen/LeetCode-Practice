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
        if (list1.empty() && list2.empty()) {
            return result;
        }
        Interval* last = NULL;
        Interval* curt = NULL;
        int i = 0; 
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1[i].start < list2[j].start) {
                curt = &list1[i];
                i++;
            } else {
                curt = &list2[j];
                j++;
            }
            last = merge(result, &last, &curt);
        }
        while (i < list1.size()) {
            Interval* p1 = &list1[i];
            last = merge(result, &last, &p1);
            i++;
        }
        while (j < list2.size()) {
            cout << result.size() << endl;
            Interval* p2 = &list2[j];
            last = merge(result, &last, &p2);
            j++;
        }
        if (last != NULL) {
            result.push_back(*last);
        }
        return result;
    }
    Interval* merge(vector<Interval>& result, Interval** last, Interval** curt) {
        if (*last == NULL) {
            return *curt;
        }
        
        if ((*curt)->start > (*last)->end) {
            result.push_back(**last);
            return *curt;
        }
        (*last)->end = std::max((*curt)->end, (*last)->end);
        return *last;
    }
};
