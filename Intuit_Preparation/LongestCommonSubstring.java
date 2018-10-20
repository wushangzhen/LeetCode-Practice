
import java.util.*;
import java.lang.String;
public class LongestCommonSubstring {
    public static List<String> find(List<String> user1, List<String> user2) {
        List<String> result = new ArrayList<>();
        if (user1 == null || user1.size() == 0 
            || user2 == null || user2.size() == 0) {
            return result;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < user1.size(); i++) {
            for (int j = 0; j < user2.size(); j++) {
                int current = 0;
                while (i + current < user1.size() 
                    && j + current < user2.size() 
                    && user1.get(i + current).equals(user2.get(j + current))) {
                    current++;    
                }
                if (max < current) {
                    index = i;
                    max = current;
                }
                i += current;
                j += current;
            }
        }
        for (int i = index; i < index + max; i++) {
            result.add(user1.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> user1 = new ArrayList<>();
        List<String> user2 = new ArrayList<>();
        user1.add("uuu");
        user1.add("xxxx");
        user1.add("zzzzz");
        user2.add("xxxx");
        user2.add("zzzzz");
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        List<String> result = lcs.find(user1, user2);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
