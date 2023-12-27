import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "";

        // создаем объект File
        File file = new File(filePath);

        // создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordCounts = new HashMap<>();

        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // закрываем Scanner
        scanner.close();

        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCounts.entrySet());

        // сортируем список по убыванию количества повторений
        Collections.sort(wordList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // выводим топ-10 слов
        int count = 1;
        for (Map.Entry<String, Integer> entry : wordList) {
            System.out.println(count + ". " + entry.getKey() + ": " + entry.getValue());
            count++;
            if (count > 10) {
                break;
            }
        }
    }
}

//Данный код выполняет анализ текстового файла и подсчитывает количество вхождений каждого слова. Вот как он работает:
//
//Сначала задаются необходимые импорты, включая классы File, Scanner, HashMap, ArrayList и Collections.
//Затем создается класс TopWords.
//В методе main определена переменная filePath, содержащая путь к текстовому файлу, который будет анализироваться.
//Создается объект File на основе указанного пути файла.
//Создается объект Scanner для чтения файла.
//В цикле while происходит построчное чтение файла с помощью scanner.hasNext(). Каждое слово приводится к нижнему регистру и добавляется в HashMap wordCounts. Если слово уже существует в wordCounts, его значение увеличивается на 1.
//После чтения файла scanner закрывается.
//Создается список wordList на основе entrySet из wordCounts.
//Список wordList сортируется в порядке убывания значений, используя компаратор.
//Затем инициализируется переменная count равная 1.
//Цикл for перебирает элементы wordList и выводит на экран номер слова, само слово и количество его вхождений.
//Переменная count инкрементируется.
//Если count превышает 10, цикл прерывается.
