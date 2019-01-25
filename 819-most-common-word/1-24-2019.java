class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        if (paragraph == null || paragraph.length() == 0) {
            return "";
        }
        Set<String> banSet = new HashSet();
        for (String word : banned) {
            banSet.add(word.toLowerCase());
        }
        int maxCount = 0;
        String res = "";
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> memo = new HashMap<>();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (sb.length() != 0) {
                String lastWord = sb.toString().toLowerCase();
                if (!banSet.contains(lastWord)) {
                    memo.put(lastWord, memo.getOrDefault(lastWord, 0) + 1);
                    if (maxCount < memo.get(lastWord)) {
                        maxCount = memo.get(lastWord);
                        res = lastWord;
                    }
                }
                sb.setLength(0);
            } 
        }
        return res;
    }
}
