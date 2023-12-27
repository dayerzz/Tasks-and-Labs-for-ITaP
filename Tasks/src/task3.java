import java.util.ArrayList;
import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(doesBlockkFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockkFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockkFit(1, 2, 2, 1, 1));
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}));
        System.out.println(salesData(new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"}, {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}}));
        System.out.println(salesData(new String[][]{{"Fridge", "Shop1", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"}, {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println(dataScience(new int[][] {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{5, 5, 5, 5, 5},{7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}}));
        System.out.println(dataScience(new int[][] {{6, 4, 19, 0, 0},{81, 25, 3, 1, 17},{48, 12, 60, 32, 14},{91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}}));
    }
    public static String replaceVowels(String str) {
        return str.replaceAll("[aeiouy]", "*");


    }
    public static String stringTransform(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String str_char = String.valueOf(str.charAt(i));
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                result.append("Double").append(str_char.toUpperCase());
                i++;
            } else {
                result.append(str_char);
            }
        }
        return result.toString();
    }
    public static boolean doesBlockkFit(int a, int b, int c, int h, int w) {
        return (a * b <= h * w || a * c <= h * w || b * c <= h * w);
    }
    public static boolean numCheck(int num) {
        int sum_squares = 0;
        int parity_num = num % 2;
        while (num > 0) {
            int last_digit = num % 10;
            sum_squares += last_digit * last_digit;
            num /= 10;
        }
        return parity_num == sum_squares % 2;
    }
    public static int countRoots(int[] coefficient) {
        int a = coefficient[0], b = coefficient[1], c = coefficient[2];
        int discr = b * b - 4 * a * c;
        if (discr < 0) {
            return 0;
        }
        if (discr == 0) {
            if (-b % (2 * a) == 0) {
                return 1;
            }
        }
        int x1 = (-b + (int) Math.sqrt(discr)) / (2 * a);
        int x2 = (-b - (int) Math.sqrt(discr)) / (2 * a);
        if (x1 == x2) {
            return 1;
        } else {
            return 2;
        }
    }
    public static ArrayList<String> salesData(String[][] magazine) {
        int maxLength = Arrays.stream(magazine).mapToInt(innerArray -> innerArray.length).max().orElse(0);
        ArrayList<String> freqPurchasedProduct = new ArrayList<>();
        for (String[] i : magazine) {
            if (i.length == maxLength) {
                freqPurchasedProduct.add(i[0]);
            }
        }
        return freqPurchasedProduct;
    }
    public static boolean validSplit(String str) {
        String[] words = str.split(" ");
        for (int i = 1; i < words.length; i++) {
            String previous = words[i - 1];
            String current = words[i];
            if (previous.charAt(previous.length() - 1) != current.charAt(0)) {
                return false;
            }
        }
        return true;
    }
    public static boolean waveForm(int[] array) {
        for (int i = 1; i < array.length - 1; i++){
            if (array[i - 1] > array[i] && array[i] < array[i + 1] || array[i - 1] < array[i] && array[i] > array[i + 1]) {
                return true;
            }
        }
        return false;
    }
    public static char commonVovel(String str) {
        str = str.toLowerCase();
        String simbols = "aeiouy";
        int[] counter = new int[5];
        for (char i : str.toCharArray()) {
            if (simbols.indexOf(i) != -1) {
                counter[simbols.indexOf(i)]++;
            }
        }
        int commonVowel = 0;
        for (int i = 0; i < counter.length - 1; i++) {
            if (counter[i] > counter[commonVowel]) {
                commonVowel = i;
            }
        }
        return simbols.charAt(commonVowel);
    }
    public static String dataScience(int[][] arrays) {
        int sumNumbers = 0;
        for (int x = 0; x < arrays[0].length; x++) {
            for (int y = 0; y < arrays[0].length; y++) {
                sumNumbers += arrays[y][x];
            }
            arrays[x][x] = sumNumbers / (arrays[0].length);
            sumNumbers = 0;
        }

        return Arrays.deepToString(arrays);
    }
}
