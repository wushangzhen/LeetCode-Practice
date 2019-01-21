/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] bf = new char[4];
        int count = 0;
        while (count < n) {
            int num = read4(bf);
            if (num == 0) {
                break;
            }
            for (int i = 0; i < num && count < n; i++) {
                buf[count++] = bf[i];
            }
            if (count == n) {
                break;
            }
        }
        return count;
    }
}
