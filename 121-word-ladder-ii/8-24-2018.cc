class Solution {
public:
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    vector<vector<string>> findLadders(string &start, string &end, unordered_set<string> &dict) {
        // write your code here
        vector<vector<string>> results;
        if (start == "" || end == "" || dict.empty()) {
            return results;
        }
        vector<string> path;
        unordered_set<string> visited;
        int min = INT_MAX;
        dict.insert(start);
        dict.insert(end);
        path.push_back(start);
        visited.push_back(start);
        dfs(results, path, start, end, dict, visited, min);
        return results;
    }
    void dfs(vector<vector<string>>& results, vector<string>& path, string start, string end, unordered_set<string>& dict, unordered_set<string>& visited, int& min) {
        if (start == end && path.size() == min) {
            results.push_back(path);
            return;
        }
        if (start == end && path.size() < min) {
            results.clear();
            results.push_back(path);
            min = path.size();
            return;
        }
        for (string next : nextWord(start, dict, visited, end)) {
            path.push_back(next);
            visited.insert(next);
            cout << next << endl;
            dfs(results, path, next, end, dict, visited, min);
            path.pop_back();
            visited.erase(next);
        }
    }
    vector<string> nextWord(string str, unordered_set<string>& dict, unordered_set<string> & visited, string end) {
        vector<string> nextWordResult;
        for (int i = 0; i < str.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                str[i] = j;
                if (dict.find(str) == dict.end() || visited.find(str) != visited.end()) {
                    cout << str << endl;
                    continue;
                }
                cout << str << endl;
                nextWordResult.push_back(str); 
            }
        }
        return nextWordResult;
    }
};
