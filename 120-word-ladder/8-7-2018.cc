class Solution {
public:
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    int ladderLength(string &start, string &end, unordered_set<string> &dict) {
        // write your code here
        if (dict.empty()) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        dict.insert(start);
        dict.insert(end);
        unordered_set<string> set1;
        queue<string> que;
        que.push(start);
        int length = 1;
        while (!que.empty()) {
            length++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                string str = que.front();
                que.pop();
                for (auto nextWord : getNextWord(str, dict)) {
                    if (set1.find(nextWord) != set1.end()) {
                        continue;
                    }
                    if (nextWord == end) {
                        return length;
                    }
                    set1.insert(nextWord);
                    que.push(nextWord);
                }
                
            }
        }
        return 0;
    }
private:
    string replace(string s, int index, char c) {
        s[index] = c; 
        return s;
    }
    vector<string> getNextWord(string word, unordered_set<string> &dict) {
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


