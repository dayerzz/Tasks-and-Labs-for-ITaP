// Импорт необходимых классов из пакетов Java для работы с файлами, исключениями и другими элементами
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;

// Определение пользовательского класса исключения CustomEmptyStackException,
// который наследуется от базового класса исключений Exception
class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException(String message) {
        super(message); // Вызов конструктора родительского класса Exception с переданным сообщением
    }
}

// Определение класса CustomStack, который имитирует стек
class CustomStack {
    private int[] stackArray; // Массив для хранения элементов стека
    private int top; // Индекс вершины стека
    private int capacity; // Вместимость стека

    // Конструктор класса CustomStack, инициализирующий переменные
    public CustomStack(int capacity) {
        this.capacity = capacity; // Установка вместимости стека
        stackArray = new int[capacity]; // Инициализация массива с заданной вместимостью
        top = -1; // Инициализация вершины стека как пустой (-1)
    }

    // Метод push для добавления элемента в стек
    public void push(int item) {
        if (top == capacity - 1) { // Проверка, переполнен ли стек
            System.out.println("Стек переполнен"); // Вывод сообщения, если стек переполнен
            return; // Выход из метода
        }
        stackArray[++top] = item; // Добавление элемента в стек и увеличение индекса вершины стека
        System.out.println(item + " добавлен в стек"); // Вывод сообщения об успешном добавлении элемента
    }

    // Метод pop для извлечения элемента из стека
    public int pop() throws CustomEmptyStackException {
        if (top == -1) { // Проверка, пуст ли стек
            throw new CustomEmptyStackException("Стек пуст"); // Выброс пользовательского исключения CustomEmptyStackException
        }
        return stackArray[top--]; // Извлечение элемента из стека и уменьшение индекса вершины стека
    }
}

// Основной класс Main
public class Main {
    // Основной метод main, с которого начинается выполнение программы
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5); // Создание объекта стека с вместимостью 5

        try { // Блок для обработки исключений
            stack.push(1); // Добавление элементов в стек
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6); // Попытка добавить элемент в переполненный стек

            for (int i = 0; i < 6; i++) { // Цикл для извлечения элементов из стека
                System.out.println(stack.pop()); // Вывод извлеченных элементов
            }
        } catch (CustomEmptyStackException e) { // Перехват пользовательского исключения
            logException(e); // Вызов метода logException для логирования исключения
        }
    }

    // Метод logException для логирования исключения в файл
    private static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("exception_log.txt", true))) { // Открытие файла для записи
            writer.println("Exception occurred: " + e.getMessage()); // Запись сообщения об исключении в файл
            e.printStackTrace(writer); // Запись стека вызовов исключения в файл
            writer.println("-------------------------------------------"); // Разделитель для читаемости лога
        } catch (IOException ex) { // Обработка исключения ввода-вывода при работе с файлом
            ex.printStackTrace(); // Вывод трассировки стека исключения в консоль
        }
    }
}
