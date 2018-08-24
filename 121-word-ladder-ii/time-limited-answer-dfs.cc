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
        visited.insert(start);
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
        vector<string> candidates = nextWord(start, dict);
        for (string next : candidates) {
            if (visited.find(next) != visited.end()) {
                continue;
            }
            path.push_back(next);
            visited.insert(next);
            //cout << next << endl;
            dfs(results, path, next, end, dict, visited, min);
            path.pop_back();
            visited.erase(next);
        }
    }
private:
    string replace(string s, int index, char c) {
        s[index] = c; 
        return s;
    }
    vector<string> nextWord(string word, unordered_set<string> &dict) {
        vector<string> res;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word[i]) {
                    continue;
                }
                string nextWord = replace(word, i, c);
                if (dict.find(nextWord) != dict.end()) {
                    res.push_back(nextWord);
                }
            }
        }
        return res;
    }

};
