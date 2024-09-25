// Wrapper class to hold the string reference
class StringWrapper {
  String value;

  public StringWrapper(String value) {
      this.value = value;
  }
}

public class permutationOfString {
  public static void main(String[] args) {
      StringWrapper a = new StringWrapper("ab");
      int start = 0;
      int end = a.value.length();
      permutationOfString(a, start, end);
  }

  public static void permutationOfString(StringWrapper a, int start, int end) {
      if (start == end - 1) {
          System.out.println(a.value);
      } else {
          for (int i = start; i < end; i++) {
            
              a.value = swap(a.value, start, i);
              permutationOfString(a, start + 1, end);
               a.value = swap(a.value, start, i);
          }
      }
  }

  public static String swap(String str, int i, int j) {
      char[] charArray = str.toCharArray();
      char temp = charArray[i];
      charArray[i] = charArray[j];
      charArray[j] = temp;
      return String.valueOf(charArray);
  }
}
