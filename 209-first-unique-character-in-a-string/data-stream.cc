class ListCharNode {
public:
    char val;
    ListCharNode* next;
    ListCharNode(char val) {
        this->val = val;
        next = NULL;
    }
};
class DataStream {
public:
    unordered_map<char, ListCharNode*> charToPrev;
    unordered_set<char> dupChars;
    ListCharNode* dummy; 
    ListCharNode* tail;
    DataStream() {
        dummy = new ListCharNode('.');
        tail = dummy;
    }
    
    void add(char c) {
        if (dupChars.find(c) != dupChars.end()) {
            return;
        }
        if (charToPrev.find(c) == charToPrev.end()) {
            ListCharNode* node = new ListCharNode(c);
            charToPrev[c] = tail; 
            tail->next = node;
            tail = node;
            return;
        }
        ListCharNode* prev = charToPrev[c];
        prev->next = prev->next->next;
        if (prev->next == NULL) {
            tail = prev;
        } else {
            charToPrev[prev->next->val] = prev;
        }
        charToPrev.erase(c);
        dupChars.insert(c);
    }
    char firstUniqChar() {
        return dummy->next->val;
    }
};
class Solution {
public:
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    char firstUniqChar(string &str) {
        DataStream ds;
        for (auto s : str) {
            ds.add(s);
        }
        return ds.firstUniqChar();
        // Write your code here
    }
};
