public class Reverse {
    public static int Test(int x) {
        long x1 = (long) x;
        int flag = 1;
        if (x1 < 0) {
            flag = -1;
        }
        x1 = Math.abs(x1);
        while (!check(x1)) {
            long temp2 = x1;
            long temp = 0;
            while (x1 != 0) {
                temp = temp * 10 + x1 % 10;
                x1 /= 10;
            }
            x1 = temp + temp2;
        }
        if (flag == -1) {
            return (int) (x1 * flag);
        }
        return (int) x1;
    }
    public static boolean check(long x) {
        while (x != 0) {
            if (x % 2 == 1) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(Reverse.Test(-168));
        
    }
}
