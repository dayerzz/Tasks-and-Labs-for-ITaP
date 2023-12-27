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
    for (int i = 0; i < str.length() - 1; i++) { // Цикл проходит по каждому символу в строке, кроме последнего символа
        char currentChar = str.toLowerCase().charAt(i); // Получаем текущий символ строки (в нижнем регистре) и сохраняем его в переменную currentChar
        
        for (int j = i + 1; j < str.length(); j++) { // Вложенный цикл начинается со следующего символа после текущего символа (i + 1)
            if (currentChar == str.charAt(j)) { // Проверяем, если текущий символ (currentChar) равен символу в другом месте строки
                return true; // Если найден дублирующий символ, возвращаем true (есть дубликаты)
            }
        }
    }
    return false;// Если после проверки всех символов не найдено дублирующих, возвращаем false (нет дубликатов)
}

    public static String getInitials(String name) {
    StringBuilder result = new StringBuilder(); // Создается объект StringBuilder для формирования строки с инициалами
    for (int i = 0; i < name.length(); i++) {  // Цикл проходит по каждому символу в строке name
        char initials = name.charAt(i); // Получаем символ строки с индексом i и сохраняем его в переменную initials

        if (Character.isUpperCase(initials)) { // Проверяем, является ли текущий символ заглавной буквой
            result.append(initials); // Если символ является заглавной, добавляем его в строку инициалов
        }
    }
    return result.toString(); // Возвращаем строку, содержащую все найденные заглавные буквы из исходной строки name
}

   public static int differenceEvenOdd(int[] numbers) {
    int even = 0; 
    int odd = 0;
    // переменные для хранения сумм чётных и нечётных чисел

    for (int i : numbers) {  // Цикл проходит по каждому элементу массива numbers
        if (i % 2 == 0) { // Если текущее число является чётным
            even += i; // Увеличиваем сумму чётных чисел на значение текущего элемента
        } else { // Если текущее число является нечётным
            odd += i; // Увеличиваем сумму нечётных чисел на значение текущего элемента
        }
    }

    return Math.max(even, odd) - Math.min(even, odd);  // Возвращаем разницу между максимальной и минимальной суммой (чётных и нечётных чисел)
}

   public static boolean equalToAvg(int[] numbers) {
    int sum = 0;     //  переменная для хранения суммы всех чисел в массиве

    for (int i : numbers) { // Цикл проходит по каждому элементу массива numbers
        sum += i; // Добавляем значение текущего элемента к сумме
    }

    double average = (double) sum / numbers.length; // Вычисление среднего значения, преобразование sum к типу double и деление на количество чисел в массиве

    for (int j : numbers) { // Цикл проходит по каждому элементу массива numbers снова
        if (j == average) { // Проверяем, равно ли текущее число среднему значению
            return true;  // Если текущее число равно среднему значению, возвращаем true
        }
    }

    return false;  // Если ни одно число не равно среднему значению, возвращаем false
}

    public static int[] indexMulti(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) { // Цикл проходит по каждому элементу массива numbers
            numbers[i] = numbers[i] * i; // Каждый элемент массива умножается на его индекс и заменяется на полученное произведение
        }
        return numbers; // Возвращается измененный массив, в котором каждый элемент умножен на свой индекс
    }
    public static String reverse(String str) {
        StringBuilder reverse = new StringBuilder(); // StringBuilder для хранения обратной версии строки
        for (int i = str.length() - 1; i >= 0; i--) { // Цикл проходит по строке str в обратном порядке, начиная с последнего символа (str.length() - 1)
            reverse.append(str.charAt(i)); // Каждый символ добавляется в объект StringBuilder в обратном порядке

        }
        return reverse.toString(); // Возвращается строка, представляющая обратную версию исходной строки str
    }
    public static int Tribonacci(int num) {
        if (num == 0 || num == 1) {
            return 0;
        } else if (num == 2) {
            return 1;
        }
        int num1 = 0, num2 = 0, num3 = 1, num4; // переменные для хранения чисел последовательности Трибоначчи
        for (int i = 3; i <= num - 1; i++) { // Цикл вычисляет следующее число последовательности
            num4 = num1 + num2 + num3; // Вычисление следующего числа в последовательности
            num1 = num2; // Обновление первого числа
            num2 = num3; // Обновление второго числа
            num3 = num4; // Обновление третьего числа
        }
        return num3; // Возвращается третье число последовательности Трибоначчи для данного числа num
    }
    public static String psuedoHash(int lenth_hash) {
        String characters = "0123456789abcdef"; // Строка с символами, из которых будет формироваться хеш-строка
        Random random = new Random(); // Создается объект типа Random для генерации случайных чисел
        StringBuilder hash = new StringBuilder();  // Создается объект StringBuilder для формирования хеш-строки
        if (lenth_hash <= 0) { 
            return ""; // Если входная длина хеша меньше или равна нулю, возвращается пустая строка
        } else {
            for (int i = 0; i <= lenth_hash - 1; i++) { // Цикл генерирует случайные символы, чтобы сформировать хеш-строку указанной длины
                int y = random.nextInt(characters.length()); // Генерируется случайное число от 0 до длины строки characters
                hash.append(characters.charAt(y)); // Добавление случайного символа из строки characters в объект StringBuilder
            }
        }
        return hash.toString(); // Возвращается сформированная хеш-строка
    }
    public static String botHelper(String str) {
        String word = "help"; // Определяется ключевое слово "help", которое мы ищем в строке str
        boolean containsword = str.contains(word); // Проверяется, содержит ли строка str ключевое слово "help". Результат сохраняется в переменной containsWord.
        return (containsword)? "Calling for a staff member" : "Keep waiting"; // Если слово "help" найдено в строке str, возвращается "Calling for a staff member", иначе возвращается "Keep waiting"
    }
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll("\\s",  "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        // Удаляем пробелы и приводим строки к нижнему регистру
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        // Преобразуем строки в массивы символов
        Arrays.sort(s1);
        Arrays.sort(s2);
        // Сортируем массивы символов
        return Arrays.equals(s1, s2); // Сравниваем отсортированные массивы символов
    }
}
