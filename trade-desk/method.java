static String MergeStrings(String[] strings) {
        // counting sort 
        if (strings == null || strings.length == 0) {
            return "";
        }
        int[] num = new int[26];
        for (String str : strings) {
            for (char c : str.toCharArray()) {
                if (c - 'a' < 26 && c - 'a' >= 0) {
                    num[c - 'a']++; // compute the number of character
                } 
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i]; j++) {
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();
    }
