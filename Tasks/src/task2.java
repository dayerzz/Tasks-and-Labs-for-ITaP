import java.util.Arrays;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Vladimir Putin"));
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));
        System.out.println(equalToAvg(new int []{1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new int []{1, 2, 3, 4, 6}));
        System.out.println(Arrays.toString(indexMulti(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMulti(new int[]{3, 3, -2, 408, 3, 31})));
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println(psuedoHash(5));
        System.out.println(psuedoHash(10));
        System.out.println(psuedoHash(0));
        System.out.println(botHelper("Hello, I`m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));

    }
    public static boolean duplicateChars(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char currentChar = str.toLowerCase().charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (currentChar == str.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static String getInitials(String name) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char initials = name.charAt(i);
            if (Character.isUpperCase(initials)) {
                result.append(initials);
            }
        }
        return result.toString();
    }
    public static int differenceEvenOdd(int[] numbers) {
        int even = 0;
        int odd = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        return Math.max(even, odd) - Math.min(even, odd);
    }
    public static boolean equalToAvg(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        double average = (double) sum / numbers.length;
        for (int j : numbers) {
            if (j == average) {
                return true;
            }
        }
        return false;
    }
    public static int[] indexMulti(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * i;
        }
        return numbers;
    }
    public static String reverse(String str) {
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));

        }
        return reverse.toString();
    }
    public static int Tribonacci(int num) {
        if (num == 0 || num == 1) {
            return 0;
        } else if (num == 2) {
            return 1;
        }
        int num1 = 0, num2 = 0, num3 = 1, num4;
        for (int i = 3; i <= num - 1; i++) {
            num4 = num1 + num2 + num3;
            num1 = num2;
            num2 = num3;
            num3 = num4;
        }
        return num3;
    }
    public static String psuedoHash(int lenth_hash) {
        String characters = "0123456789abcdef";
        Random random = new Random();
        StringBuilder hash = new StringBuilder();
        if (lenth_hash <= 0) {
            return "";
        } else {
            for (int i = 0; i <= lenth_hash - 1; i++) {
                int y = random.nextInt(characters.length());
                hash.append(characters.charAt(y));
            }
        }
        return hash.toString();
    }
    public static String botHelper(String str) {
        String word = "help";
        boolean containsword = str.contains(word);
        return (containsword)? "Calling for a staff member" : "Keep waiting";
    }
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll("\\s",  "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }
}
