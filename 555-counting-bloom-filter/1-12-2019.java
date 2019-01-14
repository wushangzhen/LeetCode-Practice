class HashFunction {
    int cap;
    int seed;
    public HashFunction(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }
    public int hash(String value) {
        char[] sc = value.toCharArray();
        int ret = 0;
        for (char c : sc) {
            ret = ret * seed + c;
            ret %= cap;
        }
        return ret;
    }
}
public class CountingBloomFilter {
    /*
    * @param k: An integer
    */
    int[] bits;
    List<HashFunction> hashFunc;
    int k;
    public CountingBloomFilter(int k) {
        // do intialization if necessary
        this.k = k;
        hashFunc = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            hashFunc.add(new HashFunction(100000 + i, 2 * i + 3));
        }
        bits = new int[100000 + k];
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int position = hashFunc.get(i).hash(word);
            bits[position] += 1;
        }
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void remove(String word) {
        // write your code here
        for (int i = 0; i < k; ++i) {
            int position = hashFunc.get(i).hash(word);
            bits[position] -= 1;
        }
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        // write your code here
        for (int i = 0; i < k; ++i) {
            int position = hashFunc.get(i).hash(word);
            if (bits[position] <= 0) {
                return false;
            }
        }
        return true;
    }
}
