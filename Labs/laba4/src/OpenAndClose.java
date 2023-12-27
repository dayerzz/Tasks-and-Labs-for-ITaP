import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FileCloseException extends Exception {
    public FileCloseException(String message) {
        super(message);
    }
}

public class OpenAndClose {
    public static void main(String[] args) {
        String sourceFilePath = ""; // Путь к исходному файлу
        String destinationFilePath = ""; // Путь к целевому файлу
        FileInputStream sourceFile = null; // Создание объекта для чтения исходного файла
        FileOutputStream destinationFile = null; // Создание объекта для записи в целевой файл

        try {
            sourceFile = new FileInputStream(sourceFilePath); // Создание потока чтения исходного файла
            destinationFile = new FileOutputStream(destinationFilePath); // Создание потока записи в целевой файл

            byte[] buffer = new byte[4096]; // Создание буфера для чтения и записи
            int bytesRead;

            while ((bytesRead = sourceFile.read(buffer)) != -1) { // Чтение данных из исходного файла в буфер
                destinationFile.write(buffer, 0, bytesRead); // Запись данных из буфера в целевой файл
            }

            System.out.println("Файл скопирован."); // Вывод сообщения об успешном копировании файла
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage()); // Обработка и вывод сообщения об ошибке
        } finally {
            if (sourceFile != null) { // Проверка, открыт ли исходный файл
                try {
                    sourceFile.close(); // Закрытие исходного файла
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии исходного файла: " + e.getMessage());
                }
            }

            if (destinationFile != null) { // Проверка, открыт ли целевой файл
                try {
                    destinationFile.close(); // Закрытие целевого файла
                } catch (IOException e) {
                    try {
                        throw new FileCloseException("Ошибка при закрытии файла назначения: " + e.getMessage());
                    } catch (FileCloseException fileCloseException) {
                        System.out.println(fileCloseException.getMessage());
                    }
                }
            }
        }
    }
}
