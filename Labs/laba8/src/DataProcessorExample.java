public class DataProcessorExample {

    @DataProcessor
    public static String processData(String data) {
        // Простая трансформация данных
        return "Результат: " + data + " Java!";
    }
}
//Этот класс содержит метод обработки данных, помеченный аннотацией @DataProcessor.
// Метод processData просто добавляет префикс "Результат: " к каждой строке данных.