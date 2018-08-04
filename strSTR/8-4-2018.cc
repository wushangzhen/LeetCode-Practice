class Solution {
public: 
    int strStr (string source, string target) {
        if (source.empty() || target.empty()) {
            return -1;
        }
        int len_s = source.length();
        int len_t = target.length();
        for (int i = 0; i < len_s; i++) {
            for (int j = 0; j < len_t; j++) {
                if (source[i + j] != target[j]) {
                    break;
                } else {
                    if (j == len_t - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
};
