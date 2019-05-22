class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b)->{
            String[] sa = a.split(" ", 2);
            String[] sb = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(sa[1].charAt(0));
            boolean isDigit2 = Character.isDigit(sb[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = sa[1].compareTo(sb[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return sa[0].compareTo(sb[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
