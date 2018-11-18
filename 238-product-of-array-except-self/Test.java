public class Test {
    public static String func(String s) {
      if (s == null || s.length() == 0) {
          return s;
      }
      char[] sc = s.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < sc.length; i++) {
          if (sc[i] == 'a' 
             || sc[i] == 'A'
             || sc[i] == 'e'
             || sc[i] == 'E'
             || sc[i] == 'I'
             || sc[i] == 'i'
             || sc[i] == 'o'
             || sc[i] == 'O'
             || sc[i] == 'u'
             || sc[i] == 'U') {
                 continue;
            }
            sb.append(sc[i]);
      }
      return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(Test.func("hello world"));
    }
}
