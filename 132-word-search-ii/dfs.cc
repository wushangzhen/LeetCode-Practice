class Solution {
public:
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    int x[4] = {0, 0, 1, -1};
    int y[4] = {1, -1, 0, 0};
    vector<string> wordSearchII(vector<vector<char>> &board, vector<string> &words) {
        // write your code here
        vector<string> results;
        unordered_set<string> hashSet;
        unordered_map<string, bool> hashMap;
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
        for (string word : words) {
            for (int i = 0; i < word.size(); i++) {
                if (hashMap.find(word.substr(0, i + 1)) == hashMap.end()) {
                    hashMap[word.substr(0, i + 1)] = false;
                }
            }
            hashMap[word] = true;
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                visited[i][j] = true;
                string str = "";
                str += board[i][j];
                dfs(hashSet, hashMap, visited, board, i, j, str);
                visited[i][j] = false;
            }
        }
        for (auto it = hashSet.begin(); it != hashSet.end(); it++) {
            results.push_back(*it);
        }
        return results;
    }
    void dfs(unordered_set<string>& hashSet, unordered_map<string, bool>& hashMap, 
            vector<vector<bool>>& visited, vector<vector<char>>& board, int i, int j,
            string str) {
        if (hashMap.find(str) == hashMap.end()) {
            return;
        }            
        if (hashMap[str]) {
            hashSet.insert(str);
        } 
        for (int k = 0; k < 4; k++) {
            int adjX = i + x[k];
            int adjY = j + y[k];
            if (!inside(board, adjX, adjY) || visited[adjX][adjY]) {
                continue;
            }
            visited[adjX][adjY] = true;
            dfs(hashSet, hashMap, visited, board, adjX, adjY, str + board[adjX][adjY]);
            visited[adjX][adjY] = false;
        }
    }
    bool inside(vector<vector<char>>& board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.size() || j >= board[0].size()) {
            return false;
        }
        return true;
    }
};
