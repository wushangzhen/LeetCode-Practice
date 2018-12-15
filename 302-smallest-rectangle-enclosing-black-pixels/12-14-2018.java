public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0) {
            return 0;
        }
        int n = image.length;
        int m = image[0].length;
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, m - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, n - 1);
        return (right - left + 1) * (bottom - top + 1);
    }
    int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (isEmptyCol(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!isEmptyCol(image, start)) {
            return start;
        }
        return end;
    }
    int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (isEmptyCol(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!isEmptyCol(image, end)) {
            return end;
        }
        return start;
    }
    int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!isEmptyRow(image, start)) {
            return start;
        }
        return end;
    }
    int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!isEmptyRow(image, end)) {
            return end;
        }
        return start;
    }
    boolean isEmptyRow(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                return false;
            }
        }
        return true;
    }
    boolean isEmptyCol(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }
}
