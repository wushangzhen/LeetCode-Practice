public class ValidWordAbbr {
    /*
    * @param dictionary: a list of words
    */
    Map<String, String> hashMap = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        for (String s : dictionary) {
            char[] sc = s.toCharArray();
            String newStr = "";
            if (s.length() > 2) {
                newStr = sc[0] + String.valueOf(sc.length - 2) 
                    + sc[sc.length - 1]; 
            } else {
                newStr = s;
            }
            hashMap.put(s, newStr);
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        char[] wc = word.toCharArray();
        String sw = "";
        if (wc.length > 2) {
            sw = wc[0] + String.valueOf(wc.length - 2) 
                    + wc[wc.length - 1]; 
        } else {
            sw = word;
        }
        if (hashMap.containsKey(word)) {
            hashMap.remove(word);
            if (hashMap.containsValue(sw)) {
                hashMap.put(word, sw);
                return false;
            } else {
                hashMap.put(word, sw);
                return true;
            }
        } else {
            if (hashMap.containsValue(sw)) {
                return false;
            } else {
                return true;
            }
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */
