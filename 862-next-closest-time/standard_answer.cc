class Solution {
public:
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    int diff = INT_MAX;
    string result = "";
    string nextClosestTime(string &time) {
        // write your code here
        set<int> set1;
        set1.insert(atoi(time.substr(0, 1).c_str()));
        set1.insert(atoi(time.substr(1, 1).c_str()));
        set1.insert(atoi(time.substr(3, 1).c_str()));
        set1.insert(atoi(time.substr(4, 1).c_str()));
        if (set1.size() == 1) {
            return time;
        }
        int minute = (atoi((time.substr(0, 2)).c_str())) * 60 + 
            atoi(time.substr(3, 2).c_str());
        dfs(set1, "", 0, minute);
        return result;
    }
    void dfs(set<int> &set1, string cur, int pos, int target) {
        if (pos == 4) {
            int m = atoi(cur.substr(0, 2).c_str()) * 60 + atoi(cur.substr(2, 2).c_str());
            if (m == target) {
                return;
            }
            int d = m - target > 0 ? m - target : 1440 + m - target;
            if (d < diff) {
                result = cur.substr(0, 2) + ":" + cur.substr(2, 2);
                diff = d;
            }
            return;
        }
        for (auto it = set1.begin(); it != set1.end(); it++) {
            if (pos == 0 && *it > 2) {
                continue;
            }
            if (pos == 1 && (atoi(cur.substr(0, 1).c_str()) * 10 + *it) > 23) {
                continue;
            }
            if (pos == 2 && *it > 5) {
                continue;
            }
            if (pos == 3 && (atoi(cur.substr(2, 1).c_str()) * 10 + *it) > 59) {
                continue;
            }
            //cout << *it << endl;
            stringstream ss;
            ss << *it;
            string str = "";
            ss >> str;
            dfs(set1, cur + str, pos + 1, target);
            
        }
    }
};
