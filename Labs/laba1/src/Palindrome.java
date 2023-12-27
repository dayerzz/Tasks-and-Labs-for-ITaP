public class Palindrome {
    public static void main(String[] args) {
        for (String s : args) {
            if (isPalindrome(s)) {
                System.out.println(s + " - является палиндромом");
            } else {
                System.out.println(s + " - не является палиндромом");
            }
        }

    }
    public static String reverseString(String s) {
        StringBuilder s2 = new StringBuilder();
//        for (int i = 0; i <= s.length(); i++){
//            s2 += s.charAt(i);
//        }
        for (int i = s.length() - 1; i >= 0; i--) {
            s2.append(s.charAt(i));
        }
        return s2.toString();
    }
    public static boolean isPalindrome(String s) {
        String s2 = reverseString(s);
        return s.equals(s2);
    }
}
