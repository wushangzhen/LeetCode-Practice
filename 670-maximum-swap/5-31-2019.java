class Solution {
    public int maximumSwap(int num) {
        char[] sc = String.valueOf(num).toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < sc.length; i++) {
            count[sc[i] - '0'] = i;
        }
        for (int i = 0; i < sc.length; i++) {
            for (char j = '9'; j > sc[i]; j--) {
                if (count[j - '0'] > i) {
                    int index = count[j - '0'];
                    char temp = sc[index];
                    sc[index] = sc[i];
                    sc[i] = temp;
                    return Integer.parseInt(String.valueOf(sc));
                }
            }
        }
        return num;
    }
}
