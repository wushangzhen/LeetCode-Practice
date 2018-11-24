/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int readPos = 0;
    int writePos = 0;
    char[] buff = new char[4];
    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i++) {
            if (readPos == writePos) {
                writePos = read4(buff);
                readPos = 0;
                if (writePos == 0) {
                    return i;
                }
            }
            buf[i] = buff[readPos++];
        }
        return n;
    }
}
