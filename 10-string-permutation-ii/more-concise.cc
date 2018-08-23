class Solution {
public:
    /**
     * @param str: A string
     * @return: all permutations
     */
    vector<string> stringPermutation2(string &str) {
        // write your code here
        vector<string> results;
        vector<bool> visited(str.size());
        string permutation;
        vector<char> cstr(str.size());
        cstr.assign(str.begin(), str.end());
        sort(cstr.begin(), cstr.end());
        dfs(cstr, visited, permutation, results);
        return results;
    }
    void dfs(vector<char>& cstr, vector<bool>& visited, string& permutation, vector<string>& results) {
        if (cstr.size() == permutation.size()) {
            results.push_back(permutation);
            return;
        }
        for (int i = 0; i < cstr.size(); i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && cstr[i] == cstr[i - 1] && !visited[i - 1]) {
                continue;
            }
            permutation += cstr[i];
            visited[i] = true;
            dfs(cstr, visited, permutation, results);
            visited[i] = false;
            permutation.pop_back();
        }
    }
};
