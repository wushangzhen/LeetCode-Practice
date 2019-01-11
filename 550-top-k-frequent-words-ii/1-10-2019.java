import java.util.NavigableSet;
public class TopK {
    /*
    * @param k: An integer
    */
    private Map<String, Integer> words = null;
    private NavigableSet<String> topk = null;
    private int k;
    private Comparator<String> myComparator = new Comparator<String>() {
        public int compare(String left, String right) {
            int left_count = words.get(left);
            int right_count = words.get(right);
            if (left_count == right_count) {
                return left.compareTo(right);
            }
            return right_count - left_count;
        }
    };
    public TopK(int k) {
        // do intialization if necessary
        this.k = k;
        words = new HashMap<>();
        topk = new TreeSet<>(myComparator);
    };

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        if (words.containsKey(word)) {
            if (topk.contains(word)) {
                topk.remove(word);
            }
            words.put(word, words.get(word) + 1);
        } else {
            words.put(word, 1);
        }
        topk.add(word);
        if (topk.size() > k) {
            topk.pollLast();
        }
    }

    /*
     * @return: the current top k frequent words.
     */
    public List<String> topk() {
        // write your code here
        List<String> results = new ArrayList<String>();
        Iterator it = topk.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            results.add(str);
        }
        return results;
    }
}
