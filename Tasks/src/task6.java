import java.util.*;
import java.util.stream.Collectors;

public class task6 {
    public static void main(String[] args) {
        // Примеры использования функции hiddenAnagram
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("-------------------------");
        System.out.println(collect("intercontinentalisationalism", 6));
        // * ["ationa", "interc", "ntalis", "ontine"]
        System.out.println(collect("strengths", 3));
        // * ["eng", "str", "ths"]
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        // * ["croscopicsilico", "pneumonoultrami", "volcanoconiosis"]
        System.out.println("-------------------------");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45))); // [9, 5]
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45))); // [3, 15]
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20))); // [4, 5]
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10))); // [2, 5]
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15))); // []
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(isExact(6))); // [6, 3]
        System.out.println(Arrays.toString(isExact(24))); // [24, 4]
        System.out.println(Arrays.toString(isExact(125))); // []
        System.out.println(Arrays.toString(isExact(720))); // [720, 6]
        System.out.println(Arrays.toString(isExact(1024))); // []
        System.out.println(Arrays.toString(isExact(40320))); // [40320, 8]
        System.out.println("-------------------------");
        System.out.println(fractions("0.(6)")); // "2/3"
        System.out.println(fractions("1.(1)")); // "10/9"
        System.out.println(fractions("3.(142857)")); // "22/7"
        System.out.println(fractions("0.19(2367)")); // "5343/27775"
        System.out.println(fractions("0.1097(3)")); // "823/7500"
        System.out.println("-------------------------");
        System.out.println(pilish_string("33314444")); // "333 1 4444"
        System.out.println(pilish_string("TOP")); // "TOP"
        System.out.println(pilish_string("X")); // "XXX"
        System.out.println(pilish_string("")); // ""
        System.out.println("-------------------------");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)")); // -17.0
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)")); // 0.0
        System.out.println("-------------------------");
        System.out.println(isValid("aabbcd")); // NO
        System.out.println(isValid("aabbccddeefghi")); // NO
        System.out.println(isValid("abcdefghhgfedecba")); // YES
        System.out.println("-------------------------");
        System.out.println(findLCS("abcd", "bd")); // "bd"
        System.out.println(findLCS("aggtab", "gxtxamb")); // "gtab"
    }
    //1
    public static String hiddenAnagram(String sentence, String word) {
        // Приведение обеих строк к нижнему регистру и удаление знаков препинания и пробелов
        String normalizedSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String normalizedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int wordLength = normalizedWord.length();

        // Проход по предложению для поиска скрытой анаграммы
        for (int i = 0; i <= normalizedSentence.length() - wordLength; i++) {
            String substring = normalizedSentence.substring(i, i + wordLength);
            // Проверка наличия анаграммы в подстроке предложения
            if (isAnagram(substring, normalizedWord)) {
                return substring;
            }
        }

        return "notfound";
    }

    // Функция для проверки является ли одна строка анаграммой другой строки
    private static boolean isAnagram(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
    //2
    public static List<String> collect(String str, int n) {
        if (str.length() < n) {
            return new ArrayList<>();
        } else {
            List<String> list = new ArrayList<>();
            list.add(str.substring(0, n));
            list.addAll(collect(str.substring(n), n));
            return list.stream().sorted().collect(Collectors.toList());
        }
    }
    //3
    public static String nicoCipher(String message, String key) {
//Вычисляется длина ключа и количество дополнительных пробелов, которые нужно добавить к сообщению,
//чтобы они делились на длину ключа. Дополнительные пробелы добавляются в конец сообщения.
        int keyLength = key.length();
        int extraSpaces = (keyLength - (message.length() % keyLength)) % keyLength;
        message += new String(new char[extraSpaces]).replace("\0", " ");
//Создается массив order длины ключа и заполняется значениями от 0 до длины ключа
        Integer[] order = new Integer[keyLength];
        for (int i = 0; i < keyLength; i++) {
            order[i] = i;
        }
//Массив order сортируется по символам ключа в лексикографическом порядке.
        Arrays.sort(order, (a, b) -> Character.compare(key.charAt(a), key.charAt(b)));
//Вычисляется результат шифрования путем перестановки символов сообщения в соответствии с порядком из массива order.
//Результат шифрования возвращается в виде строки.
        char[] result = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            int columnIndex = order[i % keyLength];
            int rowIndex = i / keyLength;
            result[i] = message.charAt(rowIndex * keyLength + columnIndex);
        }

        return new String(result);
    }
    //4
    public static int[] twoProduct(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (n % num == 0 && map.containsKey(n / num) && map.get(n / num) < i) {
                return new int[]{n / num, num};
            }
            map.put(num, i);
        }

        return new int[]{};
    }
    //5
    public static int[] isExact(int n) {
        int[] result = findExactFactorial(n, 1, 1);
        if (result[0] == n) {
            return result;
        }
        return new int[]{};
    }

    // Вспомогательная рекурсивная функция для поиска точной границы факториала
    private static int[] findExactFactorial(int target, int current, int factorial) {
        if (factorial == target) {
            return new int[]{factorial, current};
        } else if (factorial > target) {
            return new int[]{-1, -1};
        }
        return findExactFactorial(target, current + 1, factorial * (current + 1));
    }
    //6
    public static String fractions(String frac) {
        int startBracket = frac.indexOf('(');
        if (startBracket != -1) {
            String repeating = frac.substring(startBracket + 1, frac.length() - 1);
            frac = frac.substring(0, startBracket) + repeating.repeat(9 - repeating.length());
        }
        double a = Double.parseDouble(frac);
        int div = 2;
        while (Math.ceil(a * div) - a * div > 0.000001) div++;
        return (int) Math.ceil(a * div) + "/" + div;
    }
    //7
    public static String pilish_string(String str) {
        String res = "";
        String pi = String.valueOf(Math.PI).replace(".", "");
        int piIndex = 0, strIndex = 0;

        while (strIndex < str.length()) {
            int p = pi.charAt(piIndex++) - '0';
            int n = Math.min(p, str.length() - strIndex);
            res += str.substring(strIndex, strIndex + n);
            strIndex += n;
            if (strIndex < str.length()) res += ' ';
            else
                while (n++ < p) res += res.charAt(res.length() - 1);
        }
        return res;
    }
    //8
    public static double generateNonconsecutive(String expression) {
        try {
            return evaluateExpression(expression.replaceAll(" ", ""));
        } catch (Exception e) {
            return Double.NaN; // Возвращаем NaN при возникновении ошибки
        }
    }

    private static double evaluateExpression(String expr) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    num.append(expr.charAt(i));
                    i++;
                }
                i--;

                numbers.push(Double.parseDouble(num.toString()));
            } else if (c == '(') {
                operations.push(c);
            } else if (c == ')') {
                while (!operations.isEmpty() && operations.peek() != '(') {
                    applyOperation(numbers, operations);
                }
                operations.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operations.isEmpty() && hasPrecedence(c, operations.peek())) {
                    applyOperation(numbers, operations);
                }
                operations.push(c);
            }
        }

        while (!operations.isEmpty()) {
            applyOperation(numbers, operations);
        }

        return numbers.pop();
    }

    private static void applyOperation(Stack<Double> numbers, Stack<Character> operations) {
        char operation = operations.pop();
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        double result = 0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = num1 / num2;
                break;
        }

        numbers.push(result);
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }
    //9
    public static String isValid(String str) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Подсчет частоты каждого символа в строке
        for (char c : str.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Подсчет уникальных частот символов
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int frequency : charFrequency.values()) {
            frequencyCount.put(frequency, frequencyCount.getOrDefault(frequency, 0) + 1);
        }

        // Если все символы имеют одинаковую частоту - строка действительна
        if (frequencyCount.size() == 1) {
            return "YES";
        }

        // Если есть более чем две разные частоты символов - строка недействительна
        if (frequencyCount.size() > 2) {
            return "NO";
        }

        int firstFrequency = 0, secondFrequency = 0, firstCount = 0, secondCount = 0;

        // Определение частот символов
        for (int frequency : frequencyCount.keySet()) {
            if (firstFrequency == 0) {
                firstFrequency = frequency;
                firstCount = frequencyCount.get(frequency);
            } else {
                secondFrequency = frequency;
                secondCount = frequencyCount.get(frequency);
            }
        }

        // Если одна частота встречается только один раз, и удаление одного символа делает строку действительной
        if ((firstCount == 1 && (firstFrequency - 1 == secondFrequency || firstFrequency == 1))
                || (secondCount == 1 && (secondFrequency - 1 == firstFrequency || secondFrequency == 1))) {
            return "YES";
        }

        return "NO";
    }
    //10
    public static String findLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Заполняем матрицу dp с использованием динамического программирования
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Построение наибольшей общей подпоследовательности
        int index = dp[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs[index - 1] = text1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
    }
}
