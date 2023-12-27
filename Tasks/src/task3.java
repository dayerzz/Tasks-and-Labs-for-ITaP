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
    // Используется метод replaceAll для замены всех символов гласных [aeiouy] в строке на символ "*"
    }

    public static String stringTransform(String str) {
    StringBuilder result = new StringBuilder();
    // Создается объект StringBuilder для формирования преобразованной строки

    for (int i = 0; i < str.length(); i++) {
        String str_char = String.valueOf(str.charAt(i));
        // Получаем текущий символ строки str и преобразуем его в строку

        if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
            // Проверяем, если текущий символ равен следующему символу и он не последний в строке
            result.append("Double").append(str_char.toUpperCase());
            // Если символ повторяется, добавляем "Double" и текущий символ в верхнем регистре в StringBuilder
            i++; // Увеличиваем индекс на 1, чтобы пропустить следующий символ
        } else {
            result.append(str_char);
            // Если символ не повторяется, добавляем его в StringBuilder
        }
    }

    return result.toString();
    // Возвращается строка, сформированная с использованием StringBuilder
    }
    public static boolean doesBlockkFit(int a, int b, int c, int h, int w) {
        return (a * b <= h * w || a * c <= h * w || b * c <= h * w); // вычисляем поместиться ли блок в отверстие
    }
    public static boolean numCheck(int num) {
    int sum_squares = 0;
    int parity_num = num % 2;
    // Определяем начальную четность числа num (четное или нечетное), сохраняя остаток от деления на 2

    while (num > 0) {
        int last_digit = num % 10;
        // Получаем последнюю цифру числа
        sum_squares += last_digit * last_digit;
        // Добавляем квадрат последней цифры к сумме квадратов
        num /= 10;
        // Убираем последнюю цифру числа для продолжения проверки с оставшимися цифрами
    }

    return parity_num == sum_squares % 2;
    // Возвращаем результат сравнения начальной четности числа с остатком от деления суммы квадратов цифр на 2
    }

    public static int countRoots(int[] coefficient) {
        int a = coefficient[0], b = coefficient[1], c = coefficient[2];
        // Извлекаем коэффициенты a, b и c из массива coefficient

        int discr = b * b - 4 * a * c;
        // Вычисляем дискриминант

        if (discr < 0) {
            return 0;
            // Если дискриминант меньше нуля, возвращаем 0 (нет действительных корней)
         }
        if (discr == 0) {
            if (-b % (2 * a) == 0) {
                return 1;
                // Если дискриминант равен нулю и (-b) делится на (2 * a) без остатка, возвращаем 1 (один корень)
            }
        }
        // Если дискриминант больше нуля или равен нулю, но (-b) не делится на (2 * a) без остатка
        int x1 = (-b + (int) Math.sqrt(discr)) / (2 * a);
        int x2 = (-b - (int) Math.sqrt(discr)) / (2 * a);
        // Находим корни квадратного уравнения

        if (x1 == x2) {
            return 1;
            // Если корни одинаковые, возвращаем 1 (один корень)
        } else {
            return 2;
        // Если корни разные, возвращаем 2 (два различных корня)
        }
    }
    public static ArrayList<String> salesData(String[][] magazine) {
        // Находим максимальную длину внутренних массивов в двумерном массиве
        int maxLength = Arrays.stream(magazine).mapToInt(innerArray -> innerArray.length).max().orElse(0);

        // Создаем список для хранения наиболее часто покупаемых товаров
        ArrayList<String> freqPurchasedProduct = new ArrayList<>();

        // Проходимся по внутренним массивам
        for (String[] i : magazine) {
            // Если длина текущего внутреннего массива равна максимальной длине,
            // то добавляем первый элемент этого массива в список часто покупаемых товаров
            if (i.length == maxLength) {
                freqPurchasedProduct.add(i[0]);
            }
        }

        // Возвращаем список часто покупаемых товаров
        return freqPurchasedProduct;
    }
    public static boolean validSplit(String str) {
        // Разбиваем строку на слова по пробелу
        String[] words = str.split(" ");

        // Проходим по каждому слову, начиная со второго
        for (int i = 1; i < words.length; i++) {
            String previous = words[i - 1];
            String current = words[i];
        
            // Проверяем, заканчивается ли предыдущее слово на тот же символ, 
            // на который начинается текущее слово
            if (previous.charAt(previous.length() - 1) != current.charAt(0)) {
                return false; // Если условие не выполняется, возвращаем false
            }
        }
    
        return true; // Если все слова соответствуют условию, возвращаем true
    }
    public static boolean waveForm(int[] array) {
            for (int i = 1; i < array.length - 1; i++) {
            // Проверяем каждый элемент, начиная со второго до предпоследнего
            if ((array[i - 1] > array[i] && array[i] < array[i + 1]) || (array[i - 1] < array[i] && array[i] > array[i + 1])) {
                // Проверяем, является ли текущий элемент пиком волнового движения
                // Если значение в текущей позиции меньше значений по обеим сторонам или больше обоих значений, это считается пиком
                return true; // Если такой пик обнаружен, возвращаем true
            }
        }
        return false;
        // Если во всем массиве не найдено ни одной пиковой волны, возвращаем false
    }
    public static char commonVovel(String str) {
        str = str.toLowerCase();
        // Приводим все символы в строке к нижнему регистру

        String simbols = "aeiouy";
        // Создаем строку с гласными буквами

        int[] counter = new int[5];
        // Создаем массив для подсчета количества встреченных гласных

        for (char i : str.toCharArray()) {
            if (simbols.indexOf(i) != -1) {
                counter[simbols.indexOf(i)]++;
                // Подсчитываем количество каждой гласной буквы в строке
            }
        }

        int commonVowel = 0;
        // Инициализируем переменную для индекса самой часто встречающейся гласной

        for (int i = 0; i < counter.length - 1; i++) {
            if (counter[i] > counter[commonVowel]) {
                commonVowel = i;
                // Находим индекс гласной с самым большим количеством встреч в строке
            }
        }

        return simbols.charAt(commonVowel);
        // Возвращаем самую часто встречающуюся гласную букву
    }
    public static String dataScience(int[][] arrays) {
        int sumNumbers = 0;
        // Инициализируем переменную для суммирования чисел

        for (int x = 0; x < arrays[0].length; x++) {
            for (int y = 0; y < arrays[0].length; y++) {
                sumNumbers += arrays[y][x];
                // Считаем сумму чисел в столбцах
            }
            arrays[x][x] = sumNumbers / (arrays[0].length);
            // Заменяем значение в текущей позиции на среднее значение для столбца
            sumNumbers = 0;
            // Сбрасываем сумму для следующей итерации
        }

        return Arrays.deepToString(arrays);
        // Возвращаем массив в виде строки
}
