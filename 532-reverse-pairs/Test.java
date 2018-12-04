import java.util.*;
public class Test {
    public static void test(int[] A) {
        A[1] = 2;
    }
    public static void test(StringBuilder sb) {
        sb.append("1");
    }
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        Test.test(A);
        System.out.println(A[1]);
        StringBuilder sb = new StringBuilder();
        Test.test(sb);
        System.out.println(sb.toString());
    }
}
