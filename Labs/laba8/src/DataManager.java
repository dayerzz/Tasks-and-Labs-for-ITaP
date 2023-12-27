import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class DataManager {
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final ConcurrentLinkedQueue<Method> dataProcessors = new ConcurrentLinkedQueue<>();

    public void registerDataProcessor(Object processor) {
        for (Method method : processor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                dataProcessors.add(method);
            }
        }
    }

    public Stream<String> loadData(String source) throws IOException {
        return Files.lines(Paths.get(source));
    }

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

    public void saveData(String destination, Stream<String> dataStream) throws IOException {
        Files.write(Paths.get(destination), (Iterable<String>) dataStream::iterator);
    }
}
