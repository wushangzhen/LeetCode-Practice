class solution { // Rabin Carp
public:
   int strStr(const char* source, const char* target) { // const char is C type string
        if (source == NULL || target == NULL) {
            return -1;
        } // When it comes to string, we have to consider the NULL situation
        int m = strlen(target); // Then we use strlen(C) or .length(C++) to determine whether it is " "
        int n = strlen(source);
        if (m == 0) {
            return 0;
        }
        if (n == 0) {
            return -1;
        }
        int mod = rand() % 1000000 + 1000000; // The mod value is random, we can use this directly
        // do not overflow the max integer
        int hash_target = 0;
        int m26 = 1;
        
        for (int i = 0; i < m; ++i) {
            hash_target = (hash_target * 26 + target[i] - 'a') % mod; // pay attention that 'a' = 97
            // 'A' = '65' In this way we can compute a hash_target value 
            if (hash_target < 0) {
                hash_target += mod;
            }
        } // hash_target may < 0, so we have to use mod 
        for (int i = 0; i < m - 1; ++i) {
            m26 = m26 * 26 % mod;
        }
        int value = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= m) {
                value = value - (m26 * (source[i - m] - 'a')) % mod;
            }
            value = (value * 26 + source[i] - 'a') % mod;
            if (value < 0) {
                value += mod;
            }
            if (i >= m - 1 && value == hash_target) {
                char sub[m];
                memcpy(sub, &source[i - m + 1], m);
                sub[m] = '\0';
                if (strcmp(target, sub) == 0) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
};
