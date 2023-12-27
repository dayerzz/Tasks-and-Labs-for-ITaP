import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class DataManager {
    //Пул потоков: Использует ExecutorService для управления многопоточной обработкой. Пул потоков
    // создается с количеством потоков, равным числу доступных процессоров.
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final ConcurrentLinkedQueue<Method> dataProcessors = new ConcurrentLinkedQueue<>();

    //Метод registerDataProcessor регистрирует методы, помеченные аннотацией @DataProcessor.
    // Эти методы хранятся в ConcurrentLinkedQueue<Method>.
    public void registerDataProcessor(Object processor) {
        for (Method method : processor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                dataProcessors.add(method);
            }
        }
    }

    //Метод loadData читает данные из файла и возвращает их в виде потока строк (Stream<String>).
    public Stream<String> loadData(String source) throws IOException {
        return Files.lines(Paths.get(source));
    }

    //Метод processData применяет зарегистрированные методы обработки к потоку данных.
    // Обработка выполняется параллельно благодаря использованию dataStream.parallel().
    public Stream<String> processData(Stream<String> dataStream) {
        for (Method processor : dataProcessors) {
            dataStream = dataStream.parallel().map(data -> {
                try {
                    return (String) processor.invoke(null, data);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return dataStream;
    }

    //Метод saveData записывает обработанные данные обратно в файл.
    public void saveData(String destination, Stream<String> dataStream) throws IOException {
        Files.write(Paths.get(destination), (Iterable<String>) dataStream::iterator);
    }
}