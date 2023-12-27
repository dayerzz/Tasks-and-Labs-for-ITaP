public class DataProcessorExample {

    @DataProcessor
    public static String processData(String data) {
        // Простая трансформация данных
        return "Результат: " + data + " Java!";
    }
}
