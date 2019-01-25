class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        Set<String> set = new HashSet();
        for (int i = 1; i <= word.length(); i++) {
            String left = word.substring(0, i);
            List<String> right = generateAbbreviations(word.substring(i));
            for (String str : right) {
                set.add(left + str);
                int index = 0;
                String num = "";
                while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                    num += str.charAt(index++);
                }
                if (index != 0) {
                    int sum = left.length() + Integer.parseInt(num);
                    set.add(String.valueOf(sum) + str.substring(index));
                } else {
                    set.add(String.valueOf(left.length()) + str);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
